package com.example.railway_ticket_backend.service.jwt;

import com.example.railway_ticket_backend.entity.user.User;

public interface JwtService {

    String generateJwtToken(User user);

    String extractJwtToken(String token);
}
