package az.edu.turing.util;

import az.edu.turing.contoller.BookingController;
import az.edu.turing.contoller.FlightsController;
import az.edu.turing.dao.BookingDao;
import az.edu.turing.dao.FlightsDao;
import az.edu.turing.exception.InvalidMenuActionException;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightsService;

import java.util.Scanner;

public class ConsoleUtil {
    private final FlightsController flightController;
    private final BookingController bookingController;

    public ConsoleUtil(FlightsController flightController, BookingController bookingController) {
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
