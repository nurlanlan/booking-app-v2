package az.edu.turing;

import az.edu.turing.controller.BookingController;
import az.edu.turing.controller.FlightsController;
import az.edu.turing.dao.BookingDao;
import az.edu.turing.dao.FlightsDao;
import az.edu.turing.dao.impl.BookingFileDao;
import az.edu.turing.dao.impl.FlightsFileDao;
import az.edu.turing.entity.BookingEntity;
import az.edu.turing.entity.FlightsEntity;
import az.edu.turing.model.BookingDto;
import az.edu.turing.model.FlightsDto;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightsService;
import az.edu.turing.service.impl.BookingServiceImpl;
import az.edu.turing.service.impl.FlightsServiceImpl;
import az.edu.turing.util.ConsoleUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservationApp {
    public static void main(String[] args) {
        FlightsDao flightsDao = new FlightsFileDao(new ObjectMapper().registerModule(new JavaTimeModule()));
        FlightsService flightsService = new FlightsServiceImpl(flightsDao);
        FlightsController flightsController = new FlightsController(flightsService);

        BookingDao bookingDao = new BookingFileDao(new ObjectMapper().registerModule(new JavaTimeModule()));
        BookingService bookingService = new BookingServiceImpl(bookingDao);
        BookingController bookingController = new BookingController(bookingService);

        LocalDateTime dateTime1 = LocalDateTime.of(2024, 5, 2, 10, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2024, 5, 3, 12, 0);
        FlightsEntity flight1 = new FlightsEntity(dateTime1, "New York", "Salyan", 20);
        FlightsEntity flight2 = new FlightsEntity(dateTime2, "Los Angeles", "Aghcabadi", 13);
        FlightsDto flightDto1 = new FlightsDto(flight1.getFlightId(), flight1.getDepartureDateTime(), flight1.getDestination(), flight1.getLocation(), flight1.getSeats());
        FlightsDto flightDto2 = new FlightsDto(flight2.getFlightId(), flight2.getDepartureDateTime(), flight2.getDestination(), flight2.getLocation(), flight2.getSeats());
        flightsController.createFlights(flightDto1);
        flightsController.createFlights(flightDto2);
        long flightId1 = 3294692L;
        List<String> passengerNames = new ArrayList<>(Arrays.asList("Nurlan Ahmad", "Nazrin Karimova"));
        BookingEntity booking1 = new BookingEntity(flightId1, passengerNames);
        BookingDto bookingDto1 = new BookingDto(booking1.getTicketId(),booking1.getFlightId(),booking1.getPassengerNames());
        bookingController.searchAndBookFlight(bookingDto1);
        ConsoleUtil consoleUtil = new ConsoleUtil();
        consoleUtil.start();

    }
}