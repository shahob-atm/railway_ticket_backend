package com.example.railway_ticket_backend.projection.station;

import com.fasterxml.jackson.annotation.JsonRawValue;


public interface StationProjection {
    Long getStationId();
    String getStationName();
    String getRouteName();
    String getTrainName();
    String getDaysOfOperation();
    @JsonRawValue
    Object getStops();
}
