package com.example.railway_ticket_backend.service.coach;

import com.example.railway_ticket_backend.repository.CoachRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepo coachRepo;

    @Override
    public HttpEntity<?> handleGetCoaches(Long tripId) {
        return ResponseEntity.ok(coachRepo.getCoachProjections(tripId));
    }
}
