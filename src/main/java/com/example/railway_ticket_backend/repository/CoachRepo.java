package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.coach.Coach;
import com.example.railway_ticket_backend.projection.coach.CoachTypeAndCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepo extends JpaRepository<Coach, Long> {

    String sql_get_coach_type_and_count = "SELECT\n" +
            "    c.coach_type AS coach_type,\n" +
            "    COUNT(DISTINCT s.id) AS total_seats,\n" +
            "    COUNT(DISTINCT CASE WHEN ts.id IS NULL THEN s.id ELSE NULL END) AS available_seats\n" +
            "FROM\n" +
            "    coach c\n" +
            "        JOIN train tr ON c.train_id = tr.id\n" +
            "        JOIN coach_layout cl ON c.id = cl.coach_id\n" +
            "        JOIN layout_element le ON cl.id = le.coach_layout_id\n" +
            "        JOIN seat s ON le.id = s.layout_element_id\n" +
            "        LEFT JOIN trip_seat ts ON s.id = ts.seat_id AND ts.status = 'BOOKED'\n" +
            "WHERE\n" +
            "    tr.id = ? \n" +
            "GROUP BY\n" +
            "    c.coach_type;";

    @Query(value = sql_get_coach_type_and_count, nativeQuery = true)
    List<CoachTypeAndCountProjection> getCoachTypeAndCountProjection(Long trainId);
}
