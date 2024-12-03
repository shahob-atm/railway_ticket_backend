package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.service.tripSeat.TripSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trip_seat")
@RequiredArgsConstructor
public class TripSeatController {

    private final TripSeatService tripSeatService;

    @GetMapping
    public HttpEntity<?> handleGetTripSeats(@RequestParam Long tripId, @RequestParam Long coachId) {
        return tripSeatService.handleGetTripSeats(tripId, coachId);
    }
}
