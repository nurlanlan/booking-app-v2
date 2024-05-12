package az.edu.turing.controller;

import az.edu.turing.entity.BookingEntity;
import az.edu.turing.model.BookingDto;
import az.edu.turing.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingControllerTest {

    private BookingController bookingController;
    private BookingServiceStub bookingService;

    @BeforeEach
    void setUp() {
        bookingService = new BookingServiceStub();
        bookingController = new BookingController(bookingService);
    }

    @Test
    void searchAndBookFlight() {
        // Arrange
        BookingDto bookingDto = new BookingDto(1, 1, List.of("Alice", "Bob"));

        // Act
        bookingController.searchAndBookFlight(bookingDto);

        // Assert
        assertEquals(1, bookingService.bookFlightCalls);
        assertEquals(bookingDto, bookingService.lastBookingDto);
    }

    @Test
    void cancelBooking() {

        long ticketId = 1;

        bookingController.cancelBooking(ticketId);

        assertEquals(1, bookingService.cancelBookingCalls);
        assertEquals(ticketId, bookingService.lastTicketId);
    }

    @Test
    void myFlights() {

        String fullName = "Alice";
        Collection<BookingEntity> expectedBookings = new ArrayList<>(List.of(
                new BookingEntity(1, 1, List.of("Alice", "Bob")),
                new BookingEntity(2, 2, List.of("Alice", "Charlie"))
        ));
        bookingService.bookingsByPassenger = expectedBookings;

        Collection<BookingEntity> result = bookingController.myFlights(fullName);

        assertEquals(expectedBookings.size(), result.size());
        assertEquals(expectedBookings, result);
    }

    private static class BookingServiceStub implements BookingService {
        private int bookFlightCalls = 0;
        private int cancelBookingCalls = 0;
        private BookingDto lastBookingDto;
        private long lastTicketId;
        private Collection<BookingEntity> bookingsByPassenger;

        @Override
        public void bookFlight(BookingDto bookingDto) {
            bookFlightCalls++;
            lastBookingDto = bookingDto;
        }

        @Override
        public void cancelBooking(long ticketId) {
            cancelBookingCalls++;
            lastTicketId = ticketId;
        }

        @Override
        public Collection<BookingEntity> getBookingsByPassenger(String fullName) {
            return bookingsByPassenger;
        }
    }
}
