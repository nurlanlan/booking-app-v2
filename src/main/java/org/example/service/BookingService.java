package org.example.service;

import org.example.dao.BookingDao;

public class BookingService {
    private final BookingDao bookingDAO;

    public BookingService(BookingDao bookingDAO) {

        this.bookingDAO = bookingDAO;
    }


}
