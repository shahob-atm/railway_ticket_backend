package com.example.railway_ticket_backend.dto.ticket;

import com.example.railway_ticket_backend.entity.passenger.DocType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TicketDto(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotNull
        LocalDate birthDate,
        @NotNull
        DocType docType,
        @NotEmpty
        String documentNumber,
        @NotEmpty
        String documentCountry,
        @NotNull
        Long tripId,
        @NotNull
        Long tripSeatId,
        @NotNull
        Integer price
) {
}
