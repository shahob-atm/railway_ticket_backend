package com.example.railway_ticket_backend.projection.tripSeat;

public interface TripSeatProjection {
    Boolean getIsFree();
    Long getId();
    Long getTripId();
    String getPosition();
    String getSeatNumber();
}
