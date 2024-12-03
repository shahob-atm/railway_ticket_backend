package com.example.railway_ticket_backend.service.coach;

import org.springframework.http.HttpEntity;

public interface CoachService {
    HttpEntity<?> handleGetCoaches(Long tripId);
}
