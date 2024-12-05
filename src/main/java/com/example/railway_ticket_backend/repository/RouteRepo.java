package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.route.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepo extends JpaRepository<Route, Long> {
    Optional <Route> findByName(String name);
}
