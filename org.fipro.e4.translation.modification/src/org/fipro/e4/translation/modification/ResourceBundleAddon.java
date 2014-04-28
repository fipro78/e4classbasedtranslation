 
package org.fipro.e4.translation.modification;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.translation.ResourceBundleProvider;
import org.fipro.e4.translation.modification.custom.CustomResourceBundleProvider;

public class ResourceBundleAddon {
    @PostConstruct
    void postConstruct(final IEclipseContext context) {
        context.set(ResourceBundleProvider.class,
            new CustomResourceBundleProvider());
    }
}