package az.edu.turing.service;

import az.edu.turing.dao.BookingDao;

public class BookingService {
    private final BookingDao bookingDAO;

    public BookingService(BookingDao bookingDAO) {

        this.bookingDAO = bookingDAO;
    }


}
