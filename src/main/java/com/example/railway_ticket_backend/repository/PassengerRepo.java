package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {
}
