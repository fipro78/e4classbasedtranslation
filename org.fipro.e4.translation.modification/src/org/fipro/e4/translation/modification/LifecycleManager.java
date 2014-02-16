package org.fipro.e4.translation.modification;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.osgi.service.localization.BundleLocalization;
import org.fipro.e4.translation.modification.custom.CustomBundleLocalization;
import org.fipro.e4.translation.modification.custom.CustomTranslationService;

public class LifecycleManager {

	@PostContextCreate
	public void postContextCreate(final IEventBroker eventBroker, final IEclipseContext context) {
		context.set(BundleLocalization.class, 
				new CustomBundleLocalization());
		context.set(TranslationService.class, 
				ContextInjectionFactory.make(CustomTranslationService.class, context));
		
		// Use this to enable class based resource bundles for the application model
//		context.set(TranslationService.class, 
//				ContextInjectionFactory.make(ClassBasedTranslationService.class, context));
	}
}
