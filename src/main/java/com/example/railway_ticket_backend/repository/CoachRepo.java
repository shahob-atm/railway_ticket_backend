package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.coach.Coach;
import com.example.railway_ticket_backend.projection.coach.CoachProjection;
import com.example.railway_ticket_backend.projection.coach.CoachTypeAndCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepo extends JpaRepository<Coach, Long> {

    String sql_get_coach_type_and_count = "SELECT\n" +
            "    c.coach_type AS coach_type, c.price, \n" +
            "    COUNT(DISTINCT s.id) AS total_seats,\n" +
            "    COUNT(DISTINCT CASE WHEN ts.status != 'BOOKED' THEN s.id ELSE NULL END) AS available_seats\n" +
            "FROM\n" +
            "    coach c\n" +
            "        JOIN seat s ON c.id = s.coach_id\n" +
            "        LEFT JOIN trip_seat ts ON s.id = ts.seat_id\n" +
            "        LEFT JOIN trip t on ts.trip_id = t.id\n" +
            "WHERE\n" +
            "    t.id = ?\n" +
            "GROUP BY\n" +
            "    c.coach_type, c.price;";

    @Query(value = sql_get_coach_type_and_count, nativeQuery = true)
    List<CoachTypeAndCountProjection> getCoachTypeAndCountProjection(Long tripId);

    List <Coach> findCoachesByTrainId(Long trainId);

    String get_coaches = "select\n" +
            "c.id,\n" +
            "c.coach_number, c.price, \n" +
            "count(case when ts.status != 'BOOKED' then s.id else null end) as count\n" +
            "from coach c join seat s on c.id = s.coach_id\n" +
            "join trip_seat ts on s.id = ts.seat_id\n" +
            "join trip t on ts.trip_id = t.id\n" +
            "where t.id = ?\n" +
            "group by c.id";

    @Query(value = get_coaches, nativeQuery = true)
    List<CoachProjection> getCoachProjections(Long tripId);
}
