package com.example.railway_ticket_backend.config;

import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.route.RouteType;
import com.example.railway_ticket_backend.entity.routeStop.RouteStop;
import com.example.railway_ticket_backend.entity.station.Station;
import com.example.railway_ticket_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Override
    public void run(String... args) throws Exception {

        List<Station> stations = stationRepo.findAll();
        if (stations.isEmpty()) {

            List<Station> stationList = List.of(
                    Station.builder().name("Toshkent Markaziy").code("TAS-1").city("Toshkent").country("UZB").contactNumber("+998941234312").emailAddress("tas1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 0
                    Station.builder().name("Buxoro Markaziy").code("BUK-1").city("Buxoro").country("UZB").contactNumber("+998941234313").emailAddress("bux1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 1
                    Station.builder().name("Samarqand Markaziy").code("SAM-1").city("Samarqand").country("UZB").contactNumber("+998941234322").emailAddress("sam1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 2
                    Station.builder().name("Andijon Markaziy").code("AND-1").city("Andijon").country("UZB").contactNumber("+998941234315").emailAddress("and1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(), // 3
                    Station.builder().name("Nukus Markaziy").code("NUK-1").city("NUKUS").country("UZB").contactNumber("+998941234319").emailAddress("nuk1@mail.uz").openingHours("06:00-23:00").platformCount(2).build() // 4
            );

            stationRepo.saveAll(stationList);

            List<Route> routeList = List.of(
                    Route.builder().name("Andijon - Buxoro").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(1)).build(), // 0
                    Route.builder().name("Andijon - Nukus").distance(1000d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(4)).build(), // 1
                    Route.builder().name("Andijon - Toshkent").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(0)).build(), // 2
                    Route.builder().name("Andijon - Samarqand").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(2)).build(), // 3
                    Route.builder().name("Toshkent - Andijon").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(3)).build(), // 4
                    Route.builder().name("Toshkent - Samarqand").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(2)).build(), // 5
                    Route.builder().name("Toshkent - Buxuro").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(1)).build(), // 6
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
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 0
                    RouteStop.builder().route(routeList.get(0)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 0

                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 1
                    RouteStop.builder().route(routeList.get(1)).station(stationList.get(1)).stopOrder(3).arrivalTime(LocalTime.of(15, 0)).departureTime(LocalTime.of(16, 0)).build(), // 1

                    RouteStop.builder().route(routeList.get(3)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 3

                    RouteStop.builder().route(routeList.get(6)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 6

                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(14, 0)).departureTime(LocalTime.of(15, 0)).build(), // 7
                    RouteStop.builder().route(routeList.get(7)).station(stationList.get(1)).stopOrder(2).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 7

                    RouteStop.builder().route(routeList.get(8)).station(stationList.get(0)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 8

                    RouteStop.builder().route(routeList.get(11)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 11

                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 12
                    RouteStop.builder().route(routeList.get(12)).station(stationList.get(0)).stopOrder(2).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 12

                    RouteStop.builder().route(routeList.get(13)).station(stationList.get(2)).stopOrder(1).arrivalTime(LocalTime.of(12, 0)).departureTime(LocalTime.of(13, 0)).build(), // 13

                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 16
                    RouteStop.builder().route(routeList.get(16)).station(stationList.get(0)).stopOrder(3).arrivalTime(LocalTime.of(16, 0)).departureTime(LocalTime.of(17, 0)).build(), // 16

                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build(), // 17
                    RouteStop.builder().route(routeList.get(17)).station(stationList.get(2)).stopOrder(2).arrivalTime(LocalTime.of(13, 0)).departureTime(LocalTime.of(14, 0)).build(), // 17

                    RouteStop.builder().route(routeList.get(18)).station(stationList.get(1)).stopOrder(1).arrivalTime(LocalTime.of(10, 0)).departureTime(LocalTime.of(11, 0)).build() // 18
            );

            routeStopRepo.saveAll(routeStopList);
        }
    }
}
