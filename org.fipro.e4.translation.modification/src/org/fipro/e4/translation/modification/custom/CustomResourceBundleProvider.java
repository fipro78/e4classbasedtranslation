package org.fipro.e4.translation.modification.custom;

import java.util.ResourceBundle;

import org.eclipse.e4.core.internal.services.ResourceBundleHelper;
import org.eclipse.e4.core.services.translation.ResourceBundleProvider;
import org.osgi.framework.Bundle;

public class CustomResourceBundleProvider implements ResourceBundleProvider {

	@Override
	public ResourceBundle getResourceBundle(Bundle bundle, String locale) {
		//we set the base name to be an empty String for this simple example
		//you can do a lot more dependent on the bundle for example
		return ResourceBundle.getBundle("", 
				ResourceBundleHelper.toLocale(locale), 
				new CustomResourceBundleControl());
	}

}
