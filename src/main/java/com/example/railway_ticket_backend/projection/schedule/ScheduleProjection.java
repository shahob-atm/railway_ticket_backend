package com.example.railway_ticket_backend.projection.schedule;

public interface ScheduleProjection {
    Long getId();
    String getDaysOfOperation();
    Long getRouteId();
    Long getTrainId();
    Double getDistance();
    Double getSpeed();
}
