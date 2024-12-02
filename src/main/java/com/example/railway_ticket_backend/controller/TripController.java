package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.service.trip.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @GetMapping
    public HttpEntity<?> handleGetTrips(@RequestParam String fromCity, @RequestParam String toCity, @RequestParam LocalDate departureDate) {
        return tripService.handleGetTrips(fromCity, toCity, departureDate);
    }
}
