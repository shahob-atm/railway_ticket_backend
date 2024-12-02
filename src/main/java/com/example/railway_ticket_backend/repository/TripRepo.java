package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.projection.trip.TripProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepo extends JpaRepository<Trip, Long> {

    String sql_get_trips = "SELECT DISTINCT\n" +
            "    t.id,\n" +
            "    t.status,\n" +
            "    t.duration,\n" +
            "    t.arrival_date,\n" +
            "    t.departure_date,\n" +
            "    r.name,\n" +
            "    rs1.departure_time,\n" +
            "    rs1.arrival_time,\n" +
            "    st1.city,\n" +
            "    st2.city,\n" +
            "    tr.name,\n" +
            "    tr.train_type,\n" +
            "    tr.number\n" +
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
            "    train tr ON s.train_id = tr.id\n" +
            "WHERE\n" +
            "    ((st1.city = ? AND st2.city = ? AND rs1.stop_order < rs2.stop_order) OR\n" +
            "     (r.start_station_id = (SELECT id FROM station WHERE city = ?) AND\n" +
            "      r.end_station_id = (SELECT id FROM station WHERE city = ?))) AND t.departure_date = ?\n";

    @Query(value = sql_get_trips, nativeQuery = true)
    List<TripProjection> getTripProjections(String city_1, String city_2, String city_3, String city_4);
}
