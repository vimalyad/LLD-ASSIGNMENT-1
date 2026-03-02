package com.example.tickets;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH,
    CRITICAL;

    public static Priority getPriority(String priority) {
        if (priority == null) {
            throw new NullPointerException("priority is null");
        }
        try {
            return Priority.valueOf(priority.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid priority: " + priority);
        }
    }
}