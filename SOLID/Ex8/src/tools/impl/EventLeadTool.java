package tools.impl;

import tools.behaviours.EventCreationTool;
import utils.EventPlanner;

public class EventLeadTool implements EventCreationTool {
    private final EventPlanner planner;

    public EventLeadTool(EventPlanner planner) {
        this.planner = planner;
    }

    @Override
    public void createEvent(String name, double budget) {
        planner.create(name, budget);
    }

    @Override
    public int getEventsCount() {
        return planner.count();
    }
}
