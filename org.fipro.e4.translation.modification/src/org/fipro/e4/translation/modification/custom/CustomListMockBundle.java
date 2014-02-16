package org.fipro.e4.translation.modification.custom;

import java.util.ListResourceBundle;

public class CustomListMockBundle extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        { "window.title", "Custom My test application" },
        { "menu.file", "Custom File" },
        { "menu.file.open", "Custom Open" },
        { "menu.file.save", "Custom Save" },
        { "menu.file.quit", "Custom Quit" },
        { "menu.help", "Custom Help" },
        { "menu.help.about", "Custom About" },
        { "part.sample.title", "Custom My Sample Part" },
        { "part.sample.input.message", "Custom Enter text to mark part as dirty" },
        { "part.sample.tableitem.prefix", "Custom My sample item" },
    };
}
