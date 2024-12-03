package com.example.railway_ticket_backend.service.tripSeat;

import org.springframework.http.HttpEntity;

public interface TripSeatService {
    HttpEntity<?> handleGetTripSeats(Long tripId, Long coachId);
}
