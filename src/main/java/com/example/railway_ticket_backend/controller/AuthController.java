package com.example.railway_ticket_backend.controller;

import com.example.railway_ticket_backend.dto.auth.LoginDto;
import com.example.railway_ticket_backend.dto.auth.RegisterDto;
import com.example.railway_ticket_backend.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@RequestBody @Validated RegisterDto registerDto) {
        return authService.registerUser(registerDto);
    }

    @PostMapping("/login")
    public HttpEntity<?> loginUser(@RequestBody @Validated LoginDto loginDto) {
        return authService.loginUser(loginDto);
    }

    @GetMapping("/me")
    public HttpEntity<?> me() {
        return authService.me();
    }
}
