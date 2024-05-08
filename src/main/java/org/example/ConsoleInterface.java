package org.example;

import org.example.contoller.BookingController;
import org.example.contoller.FlightsController;
import org.example.dao.BookingDao;
import org.example.dao.FlightsDao;
import org.example.exception.InvalidMenuActionException;
import org.example.service.BookingService;
import org.example.service.FlightsService;

import java.util.Scanner;

public class ConsoleInterface {
    private final FlightsController flightController;
    private final BookingController bookingController;

    public ConsoleInterface(FlightsController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    private void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Online-board");
        System.out.println("2. Show flight info");
        System.out.println("3. Search and book a flight");
        System.out.println("4. Cancel booking");
        System.out.println("5. My flights");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        System.out.println("SLm"");
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
s
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        flightController.displayOnlineBoard();
                        break;
                    case 2:
                        flightController.showFlightInfo();
                        break;
                    case 3:
                        bookingController.searchAndBookFlight();
                        break;
                    case 4:
                        bookingController.cancelBooking();
                        break;
                    case 5:
                        bookingController.myFlights();
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

    public static void main(String[] args) {


    }
}
