package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.service.tripSeat.TripSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip_seat")
@RequiredArgsConstructor
public class TripSeatController {

    private final TripSeatService tripSeatService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public HttpEntity<?> handleGetTripSeats(@RequestParam Long tripId, @RequestParam Long coachId) {
        return tripSeatService.handleGetTripSeats(tripId, coachId);
    }
}
