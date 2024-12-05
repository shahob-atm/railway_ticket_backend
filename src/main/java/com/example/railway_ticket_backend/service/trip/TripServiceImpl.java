package com.example.railway_ticket_backend.service.trip;

import com.example.railway_ticket_backend.entity.coach.Coach;
import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.schedule.Schedule;
import com.example.railway_ticket_backend.entity.seat.Seat;
import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.entity.trip.TripStatus;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeatStatus;
import com.example.railway_ticket_backend.projection.schedule.ScheduleProjection;
import com.example.railway_ticket_backend.projection.trip.TripProjection;
import com.example.railway_ticket_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepo tripRepo;
    private final ScheduleRepo scheduleRepo;
    private final CoachRepo coachRepo;
    private final TripSeatRepo tripSeatRepo;
    private final SeatRepo seatRepo;
    private final RouteRepo routeRepo;

    @Override
    public HttpEntity<?> handleGetTrips(String fromCity, String toCity, LocalDate departureDate) {

        List<TripProjection> tripProjections = tripRepo.getTripProjections(fromCity, toCity, departureDate);
        String routeName = fromCity + " - " + toCity;

        if (tripProjections.isEmpty()) {

            List<ScheduleProjection> scheduleProjections = scheduleRepo.getScheduleProjections(fromCity, toCity);
            Route route = routeRepo.findByName(routeName).orElseThrow();

            DayOfWeek dayOfWeek = departureDate.getDayOfWeek();
            String dayOfWeekShort = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            for (ScheduleProjection scheduleProjection : scheduleProjections) {
                if (scheduleProjection.getDaysOfOperation().contains(dayOfWeekShort.toUpperCase())) {
                    Schedule schedule = scheduleRepo.findById(scheduleProjection.getId()).orElseThrow();

                    int totalMinutes = (int) ((route.getDistance() / scheduleProjection.getSpeed()) * 60 + 1);

                    int hours = totalMinutes / 60;
                    int minutes = totalMinutes % 60;

                    Trip trip = Trip.builder()
                            .schedule(schedule)
                            .duration(hours + ":" + minutes)
                            .status(TripStatus.ACTIVE).arrivalDate(departureDate).departureDate(departureDate).build();

                    tripRepo.save(trip);

                    List<Coach> coaches = coachRepo.findCoachesByTrainId(scheduleProjection.getTrainId());

                    for (Coach coach : coaches) {

                        List<Seat> seats = seatRepo.findSeatsByCoachId(coach.getId());

                        for (Seat seat : seats) {
                            TripSeat tripSeat = TripSeat.builder().seat(seat).status(TripSeatStatus.AVAILABLE).trip(trip).build();
                            tripSeatRepo.save(tripSeat);
                        }
                    }
                }
            }

            List<TripProjection> tripProjectionsNew = tripRepo.getTripProjections(fromCity, toCity, departureDate);

            return ResponseEntity.ok(tripProjectionsNew);
        }

        return ResponseEntity.ok(tripProjections);
    }
}
