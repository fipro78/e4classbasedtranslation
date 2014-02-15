package org.fipro.e4.translation.modification.resources;

import java.util.ListResourceBundle;

public class ListMockBundle extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
        { "window.title", "Blubb My test application" },
        { "menu.file", "Blubb File" },
        { "menu.file.open", "Blubb Open" },
        { "menu.file.save", "Blubb Save" },
        { "menu.file.quit", "Blubb Quit" },
        { "menu.help", "Blubb Help" },
        { "menu.help.about", "Blubb About" },
        { "part.sample.title", "Blubb My Sample Part" },
        { "part.sample.input.message", "Blubb Enter text to mark part as dirty" },
        { "part.sample.tableitem.prefix", "Blubb My sample item" },
    };
}
