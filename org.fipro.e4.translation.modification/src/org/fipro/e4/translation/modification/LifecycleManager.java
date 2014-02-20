package org.fipro.e4.translation.modification;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.translation.ResourceBundleProvider;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.fipro.e4.translation.modification.custom.CustomResourceBundleProvider;

public class LifecycleManager {

	@PostContextCreate
	public void postContextCreate(final IEventBroker eventBroker, final IEclipseContext context) {
		//Use this to enable custom resource bundle loading, e.g. using a custom ResourceBundle.Control
		context.set(ResourceBundleProvider.class, 
				new CustomResourceBundleProvider());
		
		// Use this to enable class based resource bundles for the application model
//		context.set(TranslationService.class, 
//				ContextInjectionFactory.make(ClassBasedTranslationService.class, context));
	}
}
