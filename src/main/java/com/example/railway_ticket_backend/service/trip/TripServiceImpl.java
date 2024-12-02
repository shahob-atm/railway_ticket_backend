package com.example.railway_ticket_backend.service.trip;

import com.example.railway_ticket_backend.repository.TripRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepo tripRepo;

    @Override
    public HttpEntity<?> handleGetTrips(String fromCity, String toCity, LocalDate departureDate) {
        return ResponseEntity.ok(tripRepo.getTripProjections(fromCity, toCity, departureDate));
    }
}
