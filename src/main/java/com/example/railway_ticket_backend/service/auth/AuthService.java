package com.example.railway_ticket_backend.service.auth;

import com.example.railway_ticket_backend.dto.auth.LoginDto;
import com.example.railway_ticket_backend.dto.auth.RegisterDto;
import org.springframework.http.HttpEntity;

public interface AuthService {

    HttpEntity<?> registerUser(RegisterDto registerDto);

    HttpEntity<?> loginUser(LoginDto loginDto);

    HttpEntity<?> me();
}
