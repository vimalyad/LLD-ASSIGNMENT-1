package tools.impl;

import tools.behaviours.MinutesTool;
import tools.behaviours.EventTool;
import utils.MinutesBook;

public class SecretaryTool implements MinutesTool, EventTool {
    private final MinutesBook book;

    public SecretaryTool(MinutesBook book) {
        this.book = book;
    }

    @Override
    public void addMinutes(String text) {
        book.add(text);
    }

    @Override
    public int getEventsCount() {
        return 0;
    }
}
