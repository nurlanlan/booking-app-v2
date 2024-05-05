package org.example.dao;

import org.example.entity.BookingEntity;

public abstract class BookingDao implements DAO<BookingEntity> {
    @Override
    public BookingEntity save(BookingEntity bookingEntity) {
        return null;
    }
}
