package az.edu.turing.dao.impl;

import az.edu.turing.dao.BookingDao;
import az.edu.turing.entity.BookingEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class BookingFileDao extends BookingDao {

    @Override
    public BookingEntity save(BookingEntity bookingEntity) {
        return null;
    }

    @Override
    public void delete(BookingEntity bookingEntity) {

    }

    @Override
    public Collection<BookingEntity> getAll() {
        return null;
    }

    @Override
    public Optional<BookingEntity> findOneBy(Predicate<BookingEntity> predicate) {
        return Optional.empty();
    }

    @Override
    public Collection<BookingEntity> findAllBy(Predicate<BookingEntity> predicate) {
        return null;
    }


}
