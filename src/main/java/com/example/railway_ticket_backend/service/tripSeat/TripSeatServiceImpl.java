package com.example.railway_ticket_backend.service.tripSeat;

import com.example.railway_ticket_backend.repository.TripSeatRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripSeatServiceImpl implements TripSeatService {

    private final TripSeatRepo tripSeatRepo;

    @Override
    public HttpEntity<?> handleGetTripSeats(Long tripId, Long coachId) {
        return ResponseEntity.ok(tripSeatRepo.getTripSeatProjections(tripId, coachId));
    }
}
