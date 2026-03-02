package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 * <p>
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 * <p>
 * TODO (student): refactor to immutable + Builder.
 */


public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;
    private final String description;
    private final Priority priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    private IncidentTicket(IncidentTicketBuilder builder) {
        this.id = builder.id;
        this.reporterEmail = builder.reporterEmail;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority != null ? Priority.getPriority(builder.priority) : Priority.LOW;
        this.tags = List.copyOf(builder.tags);
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
    }

    public String getId() {
        return id;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<String> getTags() {
        return new ArrayList<>(tags);
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public boolean isCustomerVisible() {
        return customerVisible;
    }

    public Integer getSlaMinutes() {
        return slaMinutes;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }

    public static class IncidentTicketBuilder {
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority;
        private final List<String> tags = new ArrayList<>();
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;
        private String source;

        public IncidentTicketBuilder id(String id) {
            this.id = id;
            return this;
        }

        public IncidentTicketBuilder reporterEmail(String reporterEmail) {
            this.reporterEmail = reporterEmail;
            return this;
        }

        public IncidentTicketBuilder title(String title) {
            this.title = title;
            return this;
        }

        public IncidentTicketBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IncidentTicketBuilder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public IncidentTicketBuilder tags(List<String> tags) {
            if (tags != null) {
                this.tags.addAll(tags);
            }
            return this;
        }

        public IncidentTicketBuilder assigneeEmail(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }

        public IncidentTicketBuilder customerVisible(boolean customerVisible) {
            this.customerVisible = customerVisible;
            return this;
        }

        public IncidentTicketBuilder slaMinutes(Integer slaMinutes) {
            this.slaMinutes = slaMinutes;
            return this;
        }

        public IncidentTicketBuilder source(String source) {
            this.source = source;
            return this;
        }

        public IncidentTicket build() {
            return new IncidentTicket(this);
        }
    }
}