package com.example.railway_ticket_backend.repository;

import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
import com.example.railway_ticket_backend.projection.tripSeat.TripSeatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripSeatRepo extends JpaRepository<TripSeat, Long> {

    String sql_get_trip_seat = "select\n" +
            "(case when ts.status != 'BOOKED' then true else false end) as is_free,\n" +
            "ts.id,\n" +
            "t.id as trip_id,\n" +
            "s.position,\n" +
            "s.seat_number\n" +
            "from coach c join seat s on c.id = s.coach_id\n" +
            "left join trip_seat ts on s.id = ts.seat_id\n" +
            "left join trip t on ts.trip_id = t.id\n" +
            "where t.id = ? and c.id = ? order by s.seat_number";

    @Query(value = sql_get_trip_seat, nativeQuery = true)
    List<TripSeatProjection> getTripSeatProjections(Long tripId, Long coachId);
}
