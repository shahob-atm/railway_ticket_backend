package com.example.railway_ticket_backend.service.trip;

import org.springframework.http.HttpEntity;

import java.time.LocalDate;

public interface TripService {
    HttpEntity<?> handleGetTrips(String fromCity, String toCity, LocalDate departureDate);
}
