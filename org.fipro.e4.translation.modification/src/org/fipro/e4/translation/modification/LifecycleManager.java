package org.fipro.e4.translation.modification;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.fipro.e4.translation.modification.services.CustomTranslationService;

public class LifecycleManager {

	@PostContextCreate
	public void postContextCreate(final IEventBroker eventBroker, final IEclipseContext context) {
		context.set(TranslationService.class, 
				ContextInjectionFactory.make(CustomTranslationService.class, context));
	}
}
