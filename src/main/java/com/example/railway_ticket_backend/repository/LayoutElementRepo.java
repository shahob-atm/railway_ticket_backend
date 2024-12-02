package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.layoutElement.LayoutElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LayoutElementRepo extends JpaRepository<LayoutElement, Long> {
}
