package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.station.Station;
import com.example.railway_ticket_backend.projection.station.StationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StationRepo extends JpaRepository<Station, Long> {

    Optional<Station> findByCity(String stationName);

    String sql_get_station = "WITH route_stops AS (\n" +
            "    SELECT\n" +
            "        rs_inner.route_id,\n" +
            "        json_agg(\n" +
            "                json_build_object(\n" +
            "                        'station_id', rs_inner.station_id,\n" +
            "                        'station_name', st_inner.name,\n" +
            "                        'stop_order', rs_inner.stop_order,\n" +
            "                        'arrival_time', to_char(rs_inner.arrival_time, 'HH24:MI'),\n" +
            "                        'departure_time', to_char(rs_inner.departure_time, 'HH24: MI')\n" +
            "                ) ORDER BY rs_inner.stop_order\n" +
            "        ) AS stops\n" +
            "    FROM\n" +
            "        route_stop rs_inner\n" +
            "            LEFT JOIN\n" +
            "        station st_inner ON st_inner.id = rs_inner.station_id\n" +
            "    GROUP BY\n" +
            "        rs_inner.route_id\n" +
            ")\n" +
            "SELECT\n" +
            "    s.id AS station_id,\n" +
            "    s.name AS station_name,\n" +
            "    r.name AS route_name,\n" +
            "    tr.name AS train_name,\n" +
            "    sch.days_of_operation,\n" +
            "    rs.stops\n" +
            "FROM\n" +
            "    station s\n" +
            "        JOIN\n" +
            "    route r ON s.id = r.start_station_id\n" +
            "        JOIN\n" +
            "    schedules sch ON sch.route_id = r.id\n" +
            "        JOIN\n" +
            "    transport t ON sch.transport_id = t.id\n" +
            "        JOIN\n" +
            "    train tr ON t.train_id = tr.id\n" +
            "        JOIN\n" +
            "    route_stops rs ON rs.route_id = r.id\n" +
            "WHERE\n" +
            "    s.id = ?\n" +
            "ORDER BY\n" +
            "    s.id;";

    @Query(value = sql_get_station, nativeQuery = true)
    List<StationProjection> getStationProjection(Long stationId);
}
