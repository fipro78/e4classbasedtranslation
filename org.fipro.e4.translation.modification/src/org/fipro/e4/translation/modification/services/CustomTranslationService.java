package org.fipro.e4.translation.modification.services;

import java.util.ResourceBundle;

import org.eclipse.e4.core.internal.services.BundleTranslationProvider;
import org.eclipse.e4.core.internal.services.ResourceBundleHelper;
import org.eclipse.e4.core.internal.services.ServicesActivator;
import org.eclipse.osgi.service.localization.BundleLocalization;

public class CustomTranslationService extends BundleTranslationProvider {

	@Override
	public String translate(String key, String contributorURI) {
		BundleLocalization localizationService = ServicesActivator.getDefault().getLocalizationService();
		if (localizationService == null)
			return key;
		
		ResourceBundle resourceBundle = ResourceBundleHelper.getResourceBundleForUri(
				"bundleclass://org.fipro.e4.translation.modification/org.fipro.e4.translation.modification.resources.ListMockBundle", 
				ResourceBundleHelper.toLocale(locale), 
				localizationService);
		return getResourceString(key, resourceBundle);
	}
}
