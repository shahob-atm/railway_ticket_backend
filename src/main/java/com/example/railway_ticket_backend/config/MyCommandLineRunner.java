package com.example.railway_ticket_backend.config;

import com.example.railway_ticket_backend.entity.route.Route;
import com.example.railway_ticket_backend.entity.route.RouteType;
import com.example.railway_ticket_backend.entity.station.Station;
import com.example.railway_ticket_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
                    Station.builder().name("Toshkent Markaziy").code("TAS-1").city("Toshkent").country("UZB").contactNumber("+998941234312").emailAddress("tas1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(),
                    Station.builder().name("Buxoro Markaziy").code("BUK-1").city("Buxoro").country("UZB").contactNumber("+998941234313").emailAddress("bux1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(),
                    Station.builder().name("Samarqand Markaziy").code("SAM-1").city("Samarqand").country("UZB").contactNumber("+998941234322").emailAddress("sam1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(),
                    Station.builder().name("Andijon Markaziy").code("AND-1").city("Andijon").country("UZB").contactNumber("+998941234315").emailAddress("and1@mail.uz").openingHours("06:00-23:00").platformCount(2).build(),
                    Station.builder().name("Nukus Markaziy").code("NUK-1").city("NUKUS").country("UZB").contactNumber("+998941234319").emailAddress("nuk1@mail.uz").openingHours("06:00-23:00").platformCount(2).build()
            );

            stationRepo.saveAll(stationList);

            List<Route> routeList = List.of(
                    Route.builder().name("Andijon - Buxoro").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(1)).build(),
                    Route.builder().name("Andijon - Nukus").distance(1000d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(4)).build(),
                    Route.builder().name("Andijon - Toshkent").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(0)).build(),
                    Route.builder().name("Andijon - Samarqand").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(3)).endStation(stationList.get(2)).build(),
                    Route.builder().name("Toshkent - Andijon").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(3)).build(),
                    Route.builder().name("Toshkent - Samarqand").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(2)).build(),
                    Route.builder().name("Toshkent - Buxuro").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(1)).build(),
                    Route.builder().name("Toshkent - Nukus").distance(800d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(0)).endStation(stationList.get(4)).build(),
                    Route.builder().name("Samarqand - Andijon").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(3)).build(),
                    Route.builder().name("Samarqand - Toshkent").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(0)).build(),
                    Route.builder().name("Samarqand - Buxoro").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(1)).build(),
                    Route.builder().name("Samarqand - Nukus").distance(600d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(2)).endStation(stationList.get(4)).build(),
                    Route.builder().name("Buxoro - Andijon").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(3)).build(),
                    Route.builder().name("Buxoro - Toshkent").distance(500d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(0)).build(),
                    Route.builder().name("Buxoro - Samarqand").distance(300d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(2)).build(),
                    Route.builder().name("Buxoro - Nukus").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(1)).endStation(stationList.get(4)).build(),
                    Route.builder().name("Nukus - Andijon").distance(1000d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(3)).build(),
                    Route.builder().name("Nukus - Toshkent").distance(800d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(0)).build(),
                    Route.builder().name("Nukus - Samarqand").distance(600d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(2)).build(),
                    Route.builder().name("Nukus - Buxoro").distance(700d).routeType(RouteType.INTERCITY).isActive(true).startStation(stationList.get(4)).endStation(stationList.get(1)).build()
            );

            routeRepo.saveAll(routeList);
        }
    }
}
