package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.routeStop.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStopRepo extends JpaRepository<RouteStop, Long> {
}
