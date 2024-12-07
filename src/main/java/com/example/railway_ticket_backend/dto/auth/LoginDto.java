package com.example.railway_ticket_backend.dto.auth;

import jakarta.validation.constraints.NotEmpty;

public record LoginDto(
        @NotEmpty
        String username,
        @NotEmpty
        String password
) {
}
