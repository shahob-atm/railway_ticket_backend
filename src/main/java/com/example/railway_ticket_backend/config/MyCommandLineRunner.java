package com.example.railway_ticket_backend.config;

import com.example.railway_ticket_backend.entity.Transport.Transport;
import com.example.railway_ticket_backend.entity.coach.Coach;
import com.example.railway_ticket_backend.entity.coach.CoachType;
import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.route.RouteType;
import com.example.railway_ticket_backend.entity.routeStop.RouteStop;
import com.example.railway_ticket_backend.entity.schedule.Schedule;
import com.example.railway_ticket_backend.entity.seat.Seat;
import com.example.railway_ticket_backend.entity.station.Station;
import com.example.railway_ticket_backend.entity.train.Train;
import com.example.railway_ticket_backend.entity.train.TrainType;
import com.example.railway_ticket_backend.entity.trip.Trip;
import com.example.railway_ticket_backend.entity.trip.TripStatus;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeat;
import com.example.railway_ticket_backend.entity.tripSeat.TripSeatStatus;
import com.example.railway_ticket_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyCommandLineRunner implements CommandLineRunner {

    private final StationRepo stationRepo;
    private final RouteRepo routeRepo;
    private final RouteStopRepo routeStopRepo;
    private final ScheduleRepo scheduleRepo;
    private final TrainRepo trainRepo;
    private final TripRepo tripRepo;
    private final CoachRepo coachRepo;
    private final SeatRepo seatRepo;
    private final TripSeatRepo tripSeatRepo;
    private final TransportRepo transportRepo;

    @Override
    public void run(String... args) throws Exception {

        List<Station> stations = stationRepo.findAll();
        if (stations.isEmpty()) {

            List<Station> stationList = List.of(
                    Station.builder().name("Toshkent Markaziy").code("TAS-1").city("Toshkent").country("UZB").contactNumber("+998941234312").emailAddress("tas1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 0
                    Station.builder().name("Buxoro Markaziy").code("BUK-1").city("Buxoro").country("UZB").contactNumber("+998941234313").emailAddress("bux1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 1
                    Station.builder().name("Samarqand Markaziy").code("SAM-1").city("Samarqand").country("UZB").contactNumber("+998941234322").emailAddress("sam1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 2
                    Station.builder().name("Andijon Markaziy").code("AND-1").city("Andijon").country("UZB").contactNumber("+998941234315").emailAddress("and1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 3
                    Station.builder().name("Nukus Markaziy").code("NUK-1").city("Nukus").country("UZB").contactNumber("+998941234319").emailAddress("nuk1@mail.uz").openingHours("06:00-23:00").platformCount(2).build() // 4
            );

            stationRepo.saveAll(stationList);

            List<Route> routeList = List.of(
                    Route.builder().name("Andijon - Buxoro").distance(800d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(1)).build(), // 0
                    Route.builder().name("Andijon - Nukus").distance(1000d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(4)).build(), // 1
                    Route.builder().name("Andijon - Toshkent").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(0)).build(), // 2
                    Route.builder().name("Andijon - Samarqand").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(2)).build(), // 3
                    Route.builder().name("Toshkent - Andijon").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(3)).build(), // 4
                    Route.builder().name("Toshkent - Samarqand").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(2)).build(), // 5
                    Route.builder().name("Toshkent - Buxoro").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(1)).build(), // 6
                    Route.builder().name("Toshkent - Nukus").distance(800d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(4)).build(), // 7
                    Route.builder().name("Samarqand - Andijon").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(3)).build(), // 8
                    Route.builder().name("Samarqand - Toshkent").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(0)).build(), // 9
                    Route.builder().name("Samarqand - Buxoro").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(1)).build(), // 10
                    Route.builder().name("Samarqand - Nukus").distance(600d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(4)).build(), // 11
                    Route.builder().name("Buxoro - Andijon").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(3)).build(), // 12
                    Route.builder().name("Buxoro - Toshkent").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(0)).build(), // 13
                    Route.builder().name("Buxoro - Samarqand").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(2)).build(), // 14
                    Route.builder().name("Buxoro - Nukus").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(4)).build(), // 15
                    Route.builder().name("Nukus - Andijon").distance(1000d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(3)).build(), // 16
                    Route.builder().name("Nukus - Toshkent").distance(800d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(0)).build(), // 17
                    Route.builder().name("Nukus - Samarqand").distance(600d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(2)).build(), // 18
                    Route.builder().name("Nukus - Buxoro").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(1)).build() // 19
            );

            routeRepo.saveAll(routeList);

            List<RouteStop> routeStopList = List.of(
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(3)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 0
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 0
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 0
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(1)).stopOrder(4).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 0

                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(3)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(1)).stopOrder(4).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(18, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(4)).stopOrder(5).arrivalTime(LocalTime.of(19, 0)).departureTime(LocalTime.of(20, 0)).build(), // 1

                    RouteStop.builder().route(routeList.get(2)).station(stationList.get(3)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 2
                    RouteStop.builder().route(routeList.get(2)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 2

                    RouteStop.builder().route(routeList.get(3)).station(stationList.get(3)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 3
                    RouteStop.builder().route(routeList.get(3)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(15, 0)).build(), // 3
                    RouteStop.builder().route(routeList.get(3)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 3


                    RouteStop.builder().route(routeList.get(4)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 4
                    RouteStop.builder().route(routeList.get(4)).station(stationList.get(3)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 4


                    RouteStop.builder().route(routeList.get(5)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 5
                    RouteStop.builder().route(routeList.get(5)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 5

                    RouteStop.builder().route(routeList.get(6)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 6
                    RouteStop.builder().route(routeList.get(6)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 6
                    RouteStop.builder().route(routeList.get(6)).station(stationList.get(1)).stopOrder(3).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(19, 0)).build(), // 6

                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 7
                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 7
                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(1)).stopOrder(3).arrivalTime(LocalTime.of(18, 0)).departureTime(LocalTime.of(19, 0)).build(), // 7
                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(4)).stopOrder(4).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 7

                    RouteStop.builder().route(routeList.get(8)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 8
                    RouteStop.builder().route(routeList.get(8)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 8
                    RouteStop.builder().route(routeList.get(8)).station(stationList.get(3)).stopOrder(3).arrivalTime(LocalTime.of(19, 0)).departureTime(LocalTime.of(20, 0)).build(), // 8

                    RouteStop.builder().route(routeList.get(9)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 9
                    RouteStop.builder().route(routeList.get(9)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 9

                    RouteStop.builder().route(routeList.get(10)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 10
                    RouteStop.builder().route(routeList.get(10)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 10

                    RouteStop.builder().route(routeList.get(11)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 11
                    RouteStop.builder().route(routeList.get(11)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 11
                    RouteStop.builder().route(routeList.get(11)).station(stationList.get(4)).stopOrder(3).arrivalTime(LocalTime.of(18, 0)).departureTime(LocalTime.of(19, 0)).build(), // 11

                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 12
                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 12
                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(0)).stopOrder(3).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(18, 0)).build(), // 12
                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(3)).stopOrder(4).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(23, 0)).build(), // 12

                    RouteStop.builder().route(routeList.get(13)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 13
                    RouteStop.builder().route(routeList.get(13)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 13
                    RouteStop.builder().route(routeList.get(13)).station(stationList.get(0)).stopOrder(3).arrivalTime(LocalTime.of(18, 0)).departureTime(LocalTime.of(20, 0)).build(), // 13

                    RouteStop.builder().route(routeList.get(14)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 14
                    RouteStop.builder().route(routeList.get(14)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 14

                    RouteStop.builder().route(routeList.get(15)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 15
                    RouteStop.builder().route(routeList.get(15)).station(stationList.get(4)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build(), // 15

                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(4)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(0)).stopOrder(4).arrivalTime(LocalTime.of(18, 0)).departureTime(LocalTime.of(19, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(3)).stopOrder(5).arrivalTime(LocalTime.of(20, 0)).departureTime(LocalTime.of(21, 0)).build(), // 16

                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(4)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 17
                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 17
                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 17
                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(0)).stopOrder(4).arrivalTime(LocalTime.of(18, 0)).departureTime(LocalTime.of(19, 0)).build(), // 17

                    RouteStop.builder().route(routeList.get(18)).station(stationList.get(4)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 18
                    RouteStop.builder().route(routeList.get(18)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 18
                    RouteStop.builder().route(routeList.get(18)).station(stationList.get(2)).stopOrder(3).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(16, 0)).build(), // 18

                    RouteStop.builder().route(routeList.get(19)).station(stationList.get(4)).stopOrder(1).arrivalTime(LocalTime.of(17, 0)).departureTime(LocalTime.of(20, 0)).build(), // 19
                    RouteStop.builder().route(routeList.get(19)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(21, 0)).departureTime(LocalTime.of(22, 0)).build() // 19
            );

            routeStopRepo.saveAll(routeStopList);

            List<Train> trainList = List.of(
                    Train.builder().name("Afrosiyob").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 0
                    Train.builder().name("Sharq").trainType(TrainType.REGULAR).speed(120d).capacity(300).build() // 1
//
//                    Train.builder().name("Afrosiyob").number("728F").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 2
//                    Train.builder().name("Sharq").number("618D").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 3
//
//                    Train.builder().name("Afrosiyob").number("178F").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 4
//                    Train.builder().name("Sharq").number("298D").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 5
//
//                    Train.builder().name("Afrosiyob").number("138F").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 6
//                    Train.builder().name("Sharq").number("145D").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 7
//
//                    Train.builder().name("Afrosiyob").number("154D").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 8
//                    Train.builder().name("Sharq").number("988D").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 9
//
//                    Train.builder().name("Afrosiyob").number("655A").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 10
//                    Train.builder().name("Sharq").number("433V").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 11
//
//                    Train.builder().name("Afrosiyob").number("876G").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 12
//                    Train.builder().name("Sharq").number("322S").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 13
//
//                    Train.builder().name("Afrosiyob").number("111X").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 14
//                    Train.builder().name("Sharq").number("456B").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 15
//
//                    Train.builder().name("Afrosiyob").number("765N").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 16
//                    Train.builder().name("Sharq").number("877M").trainType(TrainType.REGULAR).speed(120d).capacity(300).build(), // 17
//
//                    Train.builder().name("Afrosiyob").number("888K").trainType(TrainType.EXPRESS).speed(320d).capacity(200).build(), // 18
//                    Train.builder().name("Sharq").number("837Z").trainType(TrainType.REGULAR).speed(120d).capacity(300).build() // 19
            );

            trainRepo.saveAll(trainList);

            List<Transport> transportList = List.of(
                    Transport.builder().number("778F").train(trainList.get(0)).build(), // 1
                    Transport.builder().number("178F").train(trainList.get(1)).build(), // 2
                    Transport.builder().number("278F").train(trainList.get(0)).build(), // 3
                    Transport.builder().number("378F").train(trainList.get(1)).build(), // 4
                    Transport.builder().number("478F").train(trainList.get(0)).build(), // 5
                    Transport.builder().number("578F").train(trainList.get(1)).build(), // 6
                    Transport.builder().number("678F").train(trainList.get(0)).build(), // 7
                    Transport.builder().number("878F").train(trainList.get(1)).build(), // 8
                    Transport.builder().number("978F").train(trainList.get(0)).build(), // 9
                    Transport.builder().number("078F").train(trainList.get(1)).build(), // 10
                    Transport.builder().number("718F").train(trainList.get(0)).build(), // 11
                    Transport.builder().number("728F").train(trainList.get(1)).build(), // 12
                    Transport.builder().number("738F").train(trainList.get(0)).build(), // 13
                    Transport.builder().number("748F").train(trainList.get(1)).build(), // 14
                    Transport.builder().number("758F").train(trainList.get(0)).build(), // 15
                    Transport.builder().number("768F").train(trainList.get(1)).build(), // 16
                    Transport.builder().number("788F").train(trainList.get(0)).build(), // 17
                    Transport.builder().number("798F").train(trainList.get(1)).build(), // 18
                    Transport.builder().number("708F").train(trainList.get(0)).build(), // 19
                    Transport.builder().number("771F").train(trainList.get(1)).build() // 20
            );

            transportRepo.saveAll(transportList);

            List<Schedule> scheduleList = List.of(
                    Schedule.builder().route(routeList.get(0)).transport(transportList.get(0)).daysOfOperation("MON, WED, FRI").build(), // 0
                    Schedule.builder().route(routeList.get(1)).transport(transportList.get(1)).daysOfOperation("TUE, THU, SAT").build(), // 1
                    Schedule.builder().route(routeList.get(2)).transport(transportList.get(2)).daysOfOperation("MON, WED, FRI").build(), // 2
                    Schedule.builder().route(routeList.get(3)).transport(transportList.get(3)).daysOfOperation("TUE, THU, SAT").build(), // 3
                    Schedule.builder().route(routeList.get(4)).transport(transportList.get(4)).daysOfOperation("MON, WED, FRI").build(), // 4
                    Schedule.builder().route(routeList.get(5)).transport(transportList.get(5)).daysOfOperation("TUE, THU, SAT").build(), // 5
                    Schedule.builder().route(routeList.get(6)).transport(transportList.get(6)).daysOfOperation("MON, WED, FRI").build(), // 6
                    Schedule.builder().route(routeList.get(7)).transport(transportList.get(7)).daysOfOperation("TUE, THU, SAT").build(), // 7
                    Schedule.builder().route(routeList.get(8)).transport(transportList.get(8)).daysOfOperation("MON, WED, FRI").build(), // 8
                    Schedule.builder().route(routeList.get(9)).transport(transportList.get(9)).daysOfOperation("TUE, THU, SAT").build(), // 9
                    Schedule.builder().route(routeList.get(10)).transport(transportList.get(10)).daysOfOperation("MON, WED, FRI").build(), // 10
                    Schedule.builder().route(routeList.get(11)).transport(transportList.get(11)).daysOfOperation("TUE, THU, SAT").build(), // 11
                    Schedule.builder().route(routeList.get(12)).transport(transportList.get(12)).daysOfOperation("MON, WED, FRI").build(), // 12
                    Schedule.builder().route(routeList.get(13)).transport(transportList.get(13)).daysOfOperation("TUE, THU, SAT").build(), // 13
                    Schedule.builder().route(routeList.get(14)).transport(transportList.get(14)).daysOfOperation("MON, WED, FRI").build(), // 14
                    Schedule.builder().route(routeList.get(15)).transport(transportList.get(15)).daysOfOperation("TUE, THU, SAT").build(), // 15
                    Schedule.builder().route(routeList.get(16)).transport(transportList.get(16)).daysOfOperation("MON, WED, FRI").build(), // 16
                    Schedule.builder().route(routeList.get(17)).transport(transportList.get(17)).daysOfOperation("TUE, THU, SAT").build(), // 17
                    Schedule.builder().route(routeList.get(18)).transport(transportList.get(18)).daysOfOperation("MON, WED, FRI").build(), // 18
                    Schedule.builder().route(routeList.get(19)).transport(transportList.get(19)).daysOfOperation("TUE, THU, SAT").build() // 19
            );

            scheduleRepo.saveAll(scheduleList);

            List<Trip> tripList = List.of(
                    Trip.builder().schedule(scheduleList.get(0)).departureDate(LocalDate.of(2024, 12, 4)).arrivalDate(LocalDate.of(2024, 12, 4)).status(TripStatus.ACTIVE).duration("4:00").build(), // 0
                    Trip.builder().schedule(scheduleList.get(6)).departureDate(LocalDate.of(2024, 12, 20)).arrivalDate(LocalDate.of(2024, 12, 20)).status(TripStatus.ACTIVE).duration("4:00").build()
            );

            tripRepo.saveAll(tripList);

            List<Coach> coachList = List.of(
                    Coach.builder().train(trainList.get(0)).coachNumber(1).coachType(CoachType.VIP).price(12000).capacity(12).build(), // 0
                    Coach.builder().train(trainList.get(0)).coachNumber(2).coachType(CoachType.BUSINESS).price(15000).capacity(12).build(), // 1

                    Coach.builder().train(trainList.get(1)).coachNumber(1).coachType(CoachType.VIP).capacity(12).price(13000).build(), // 2
                    Coach.builder().train(trainList.get(1)).coachNumber(2).coachType(CoachType.SEATER).capacity(12).price(14000).build() // 3
            );

            coachRepo.saveAll(coachList);

            List<Seat> seatList = List.of(
                    // 0 poyezd
                    // 0
                    Seat.builder().seatNumber("A1").position("L").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("B1").position("L").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("C1").position("L").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("A2").position("L").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("B2").position("L").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("C2").position("L").coach(coachList.get(0)).build(),

                    Seat.builder().seatNumber("A1").position("R").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("B1").position("R").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("C1").position("R").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("A2").position("R").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("B2").position("R").coach(coachList.get(0)).build(),
                    Seat.builder().seatNumber("C2").position("R").coach(coachList.get(0)).build(),

                    // 2
                    Seat.builder().seatNumber("A1").position("L").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("B1").position("L").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("C1").position("L").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("A2").position("L").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("B2").position("L").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("C2").position("L").coach(coachList.get(1)).build(),

                    Seat.builder().seatNumber("A1").position("R").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("B1").position("R").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("C1").position("R").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("A2").position("R").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("B2").position("R").coach(coachList.get(1)).build(),
                    Seat.builder().seatNumber("C2").position("R").coach(coachList.get(1)).build(),

                    // 1 poyezd
                    // 3
                    Seat.builder().seatNumber("A1").position("L").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("B1").position("L").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("C1").position("L").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("A2").position("L").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("B2").position("L").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("C2").position("L").coach(coachList.get(2)).build(),

                    Seat.builder().seatNumber("A1").position("R").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("B1").position("R").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("C1").position("R").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("A2").position("R").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("B2").position("R").coach(coachList.get(2)).build(),
                    Seat.builder().seatNumber("C2").position("R").coach(coachList.get(2)).build(),

                    // 4
                    Seat.builder().seatNumber("A1").position("L").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("B1").position("L").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("C1").position("L").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("A2").position("L").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("B2").position("L").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("C2").position("L").coach(coachList.get(3)).build(),

                    Seat.builder().seatNumber("A1").position("R").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("B1").position("R").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("C1").position("R").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("A2").position("R").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("B2").position("R").coach(coachList.get(3)).build(),
                    Seat.builder().seatNumber("C2").position("R").coach(coachList.get(3)).build()
            );

            seatRepo.saveAll(seatList);

            List<TripSeat> tripSeatList = new ArrayList<>();
            int count = 0;
            for (Seat seat : seatList) {
                if (count < seatList.size() / 2) {
                    TripSeat tripSeat = TripSeat.builder().seat(seat).trip(tripList.get(0)).status(TripSeatStatus.AVAILABLE).build();
                    tripSeatList.add(tripSeat);
                }else {
                    TripSeat tripSeat = TripSeat.builder().seat(seat).trip(tripList.get(1)).status(TripSeatStatus.AVAILABLE).build();
                    tripSeatList.add(tripSeat);
                }
                count++;
            }

            tripSeatRepo.saveAll(tripSeatList);
        }
    }
}
