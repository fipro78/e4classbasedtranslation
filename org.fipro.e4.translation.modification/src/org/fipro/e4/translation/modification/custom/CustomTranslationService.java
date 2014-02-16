package org.fipro.e4.translation.modification.custom;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.eclipse.e4.core.internal.services.BundleTranslationProvider;
import org.eclipse.e4.core.internal.services.ResourceBundleHelper;
import org.eclipse.e4.core.internal.services.ServicesActivator;
import org.eclipse.osgi.service.localization.BundleLocalization;
import org.osgi.framework.Bundle;
import org.osgi.service.log.LogService;
import org.osgi.service.packageadmin.PackageAdmin;

public class CustomTranslationService extends BundleTranslationProvider {
	/**
	 * The schema identifier used for Eclipse platform references
	 */
	final private static String PLATFORM_SCHEMA = "platform"; //$NON-NLS-1$
	final private static String PLUGIN_SEGMENT = "/plugin/"; //$NON-NLS-1$
	final private static String FRAGMENT_SEGMENT = "/fragment/"; //$NON-NLS-1$

	@Inject
	BundleLocalization localizationService;
	
	@Override
	public String translate(String key, String contributorURI) {
		Bundle bundle = getBundle(contributorURI);
		if (bundle == null)
			return key;

		if (localizationService == null)
			return key;
		
		ResourceBundle resourceBundle = localizationService.getLocalization(bundle, locale);
		return getResourceString(key, resourceBundle);
	}
	
	private Bundle getBundle(String contributorURI) {
		if (contributorURI == null)
			return null;
		URI uri;
		try {
			uri = new URI(contributorURI);
		} catch (URISyntaxException e) {
			LogService logService = ServicesActivator.getDefault().getLogService();
			if (logService != null)
				logService.log(LogService.LOG_ERROR, "Invalid contributor URI: " + contributorURI); //$NON-NLS-1$
			return null;
		}
		if (!PLATFORM_SCHEMA.equals(uri.getScheme()))
			return null; // not implemented
		String bundleName = uri.getPath();
		if (bundleName.startsWith(PLUGIN_SEGMENT))
			bundleName = bundleName.substring(PLUGIN_SEGMENT.length());
		else if (bundleName.startsWith(FRAGMENT_SEGMENT))
			bundleName = bundleName.substring(FRAGMENT_SEGMENT.length());
		PackageAdmin packageAdmin = ServicesActivator.getDefault().getPackageAdmin();
		Bundle[] bundles = packageAdmin.getBundles(bundleName, null);
		if (bundles == null)
			return null;
		// Return the first bundle that is not installed or uninstalled
		for (int i = 0; i < bundles.length; i++) {
			if ((bundles[i].getState() & (Bundle.INSTALLED | Bundle.UNINSTALLED)) == 0) {
				return bundles[i];
			}
		}
		return null;
	}

}
