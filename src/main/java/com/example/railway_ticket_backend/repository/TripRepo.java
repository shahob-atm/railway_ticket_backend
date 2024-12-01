package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {
}
