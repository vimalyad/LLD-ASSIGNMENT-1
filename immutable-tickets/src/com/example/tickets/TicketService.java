package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 * <p>
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 * <p>
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        Validation.requireTicketId(id);
        Validation.requireEmail(reporterEmail, "reporterEmail");
        Validation.requireNonBlank(title, "title");

        return new IncidentTicket.IncidentTicketBuilder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(List.of("NEW"))
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        List<String> updatedTags = new ArrayList<>(t.getTags());
        updatedTags.add("ESCALATED");

        return new IncidentTicket.IncidentTicketBuilder()
                .id(t.getId())
                .reporterEmail(t.getReporterEmail())
                .title(t.getTitle())
                .description(t.getDescription())
                .assigneeEmail(t.getAssigneeEmail())
                .customerVisible(t.isCustomerVisible())
                .slaMinutes(t.getSlaMinutes())
                .source(t.getSource())
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        Validation.requireOptionalEmail(assigneeEmail, "assigneeEmail");

        return new IncidentTicket.IncidentTicketBuilder()
                .id(t.getId())
                .reporterEmail(t.getReporterEmail())
                .title(t.getTitle())
                .description(t.getDescription())
                .priority(t.getPriority().name())
                .tags(t.getTags())
                .customerVisible(t.isCustomerVisible())
                .slaMinutes(t.getSlaMinutes())
                .source(t.getSource())
                .assigneeEmail(assigneeEmail)
                .build();
    }
}