package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.schedule.Schedule;
import com.example.railway_ticket_backend.projection.schedule.ScheduleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    String get_schedule = "select\n" +
            "s.id,\n" +
            "s.days_of_operation,\n" +
            "s.route_id,\n" +
            "s.train_id, r.distance,\n" +
            "t.speed\n" +
            "from schedules s join route r on s.route_id = r.id\n" +
            "join train t on s.train_id = t.id\n" +
            "        JOIN\n" +
            "    route_stop rs1 ON r.id = rs1.route_id\n" +
            "        JOIN\n" +
            "    route_stop rs2 ON r.id = rs2.route_id\n" +
            "        JOIN\n" +
            "    station st1 ON rs1.station_id = st1.id\n" +
            "        JOIN\n" +
            "    station st2 ON rs2.station_id = st2.id\n" +
            "WHERE\n" +
            "    (st1.city = ? AND st2.city = ? AND rs1.stop_order < rs2.stop_order)";
    @Query(value =  get_schedule, nativeQuery = true)
    List<ScheduleProjection> getScheduleProjections(String fromCity, String toCity);
}
