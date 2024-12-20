package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.projection.trip.TripProjection;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TripRepo extends JpaRepository<Trip, Long> {

    String sql_get_trips = "SELECT DISTINCT\n" +
            "    t.id AS trip_id,\n" +
            "    t.status,\n" +
            "    t.duration,\n" +
            "    t.arrival_date,\n" +
            "    t.departure_date,\n" +
            "    r.name AS route_name,\n" +
            "    to_char(rs1.departure_time, 'HH24:MI') as departure_time,\n" +
            "    to_char(rs2.arrival_time, 'HH24:MI') as arrival_time,\n" +
            "    st1.city AS start_city,\n" +
            "    st2.city AS end_city,\n" +
            "    tr.name AS train_name,\n" +
            "    tr.train_type,\n" +
            "    trp.number,\n" +
            "    tr.capacity,\n" +
            "    tr.id as train_id\n" +
            "FROM\n" +
            "    trip t\n" +
            "        JOIN\n" +
            "    schedules s ON t.schedule_id = s.id\n" +
            "        JOIN\n" +
            "    route r ON s.route_id = r.id\n" +
            "        JOIN\n" +
            "    route_stop rs1 ON r.id = rs1.route_id\n" +
            "        JOIN\n" +
            "    route_stop rs2 ON r.id = rs2.route_id\n" +
            "        JOIN\n" +
            "    station st1 ON rs1.station_id = st1.id\n" +
            "        JOIN\n" +
            "    station st2 ON rs2.station_id = st2.id\n" +
            "        JOIN\n" +
            "    transport trp ON s.transport_id = trp.id\n" +
            "        jOIN\n" +
            "    train tr on trp.train_id = tr.id\n" +
            "WHERE\n" +
            "    (st1.city = ? AND st2.city = ? AND rs1.stop_order < rs2.stop_order) AND (t.departure_date = ?)\n" +
            "GROUP BY\n" +
            "    t.id, t.status, t.duration, t.arrival_date, t.departure_date, r.name,\n" +
            "    rs1.departure_time, rs2.arrival_time, st1.city, st2.city, tr.name, tr.train_type,\n" +
            "    trp.number, tr.capacity, tr.id;";

    @Query(value = sql_get_trips, nativeQuery = true)
    List<TripProjection> getTripProjections(String city_1, String city_2, LocalDate departureDate);

    String sql_update = "update trip set status = ? where departure_date < current_date";

    @Modifying
    @Transactional
    @Query(value = sql_update, nativeQuery = true)
    void updateTripStatus(String status);
}
