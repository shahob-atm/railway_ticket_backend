package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.coachLayout.CoachLayout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachLayoutRepo extends JpaRepository<CoachLayout, Long> {
}
