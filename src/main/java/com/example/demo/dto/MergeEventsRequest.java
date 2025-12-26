package com.example.demo.dto;

import java.util.List;

public class MergeEventsRequest {

    private List<Long> eventIds;
    private String reason;

    public MergeEventsRequest() {}

    public MergeEventsRequest(List<Long> eventIds, String reason) {
        this.eventIds = eventIds;
        this.reason = reason;
    }

    public List<Long> getEventIds() {
        return eventIds;
    }

    public String getReason() {
        return reason;
    }
}
