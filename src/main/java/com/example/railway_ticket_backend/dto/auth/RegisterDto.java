package com.example.railway_ticket_backend.dto.auth;

import jakarta.validation.constraints.NotEmpty;

public record RegisterDto(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
