package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.service.coach.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @GetMapping
    public HttpEntity<?> handleGetCoaches(@RequestParam Long tripId) {
        return coachService.handleGetCoaches(tripId);
    }
}
