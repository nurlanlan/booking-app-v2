package az.edu.turing.util;

import az.edu.turing.controller.FlightsController;
import az.edu.turing.dao.FlightsDao;
import az.edu.turing.dao.impl.FlightsFileDao;
import az.edu.turing.entity.FlightsEntity;
import az.edu.turing.exception.InvalidMenuActionException;
import az.edu.turing.model.FlightsDto;
import az.edu.turing.service.FlightsService;
import az.edu.turing.service.impl.FlightsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleUtil {
    FlightsDao flightsDao = new FlightsFileDao(new ObjectMapper());
    FlightsService flightsService = new FlightsServiceImpl(flightsDao);
    FlightsController flightsController = new FlightsController(flightsService);


    LocalDateTime dateTime1 = LocalDateTime.of(2024, 5, 2, 10, 0);
    LocalDateTime dateTime2 = LocalDateTime.of(2024, 5, 3, 12, 0);
    FlightsEntity flight1 = new FlightsEntity(dateTime1, "New York", "Salyan", 20);
    FlightsEntity flight2 = new FlightsEntity(dateTime2, "Los Angeles", "Aghcabadi", 13);

    public void displayMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1. Online-board");
        System.out.println("2. Show flight info");
        System.out.println("3. Search and book a flight");
        System.out.println("4. Cancel booking");
        System.out.println("5. My flights");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        displayOnlineBoard();
                        break;
                    case 2:
                        showFlightInfo();
                        break;
                    case 3:
                        searchAndBookFlight();
                        break;
                    case 4:
                        cancelBooking();
                        break;
                    case 5:
                        myFlights();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        throw new InvalidMenuActionException("Invalid choice! Please try again.");
                }
            } catch (InvalidMenuActionException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 6);

        scanner.close();
    }

    public void displayOnlineBoard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();
        List<FlightsDto> flights = flightsController.getOnlineBoard(location, dateTime);
        for (FlightsDto flight : flights) {
            System.out.println(flight.getFlightId() + " - " + flight.getDestination() + " - " +
                    flight.getDepartureDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public void showFlightInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter flight ID: ");
        long id = scanner.nextLong();
        List<FlightsDto> flights = flightsController.getFlightInfoByFlightId(id);
        System.out.println("===== Flight Info =====");
        if (flights != null) {
            for (FlightsDto f : flights) {
                System.out.println(f.getDepartureDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " - "
                        + f.getDestination() + " - "
                        + f.getSeats()
                );
            }
        } else {
            System.out.println("Flight not found!");
        }
    }

    public void searchAndBookFlight() {

    }

    public void cancelBooking() {

    }

    public void myFlights() {

    }
}