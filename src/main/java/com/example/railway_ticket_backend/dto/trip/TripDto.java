package com.example.railway_ticket_backend.dto.trip;

import java.time.LocalDate;

public record TripDto(
        String fromCity,
        String toCity,
        LocalDate departureDate
) {
}
