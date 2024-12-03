package com.example.railway_ticket_backend.projection.coach;

public interface CoachTypeAndCountProjection {
    String getCoachType();
    Integer getPrice();
    Integer getTotalSeats();
    Integer getAvailableSeats();
}
