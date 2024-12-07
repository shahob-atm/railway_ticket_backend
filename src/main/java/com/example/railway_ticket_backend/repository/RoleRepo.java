package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Long> {
    List<Role> findAllByName(String name);
}
