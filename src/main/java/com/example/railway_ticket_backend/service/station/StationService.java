package com.example.railway_ticket_backend.service.station;

import org.springframework.http.HttpEntity;

public interface StationService {
    HttpEntity<?> handleGetStations(String stationName);
}
