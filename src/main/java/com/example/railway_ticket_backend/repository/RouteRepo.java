package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route, Long> {
}
