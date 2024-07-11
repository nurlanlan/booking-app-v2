package az.edu.turing.dao.impl;

import az.edu.turing.dao.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookingPotgresDao implements DAO {


    private static final String getBookingByIdSql = "SELECT * FROM booking WHERE id = ?;";
    private static final String createBookingSql = "INSERT INTO booking (flight_id) VALUES (?);";
    private static final String createPassengerNameSql = "INSERT INTO passenger (full_name) VALUES (?);";
    private static final String createBookingByPassengerIdSql = "INSERT INTO bookings_passengers (booking_id, passenger_id) VALUES (?, ?);";
    private static final String deleteBookingSql = "DELETE FROM booking WHERE id = ?;";
    private static final String deletePassengerNameSql = "DELETE FROM passenger WHERE id = ?;";
    private static final String getAllBookingSql = "SELECT booking.id, booking.flight_id, string_agg(passenger.full_name, ',') as passenger_name FROM booking JOIN bookings_passengers ON booking.id = bookings_passengers.booking_id JOIN passenger ON bookings_passengers.passenger_id = passenger.id GROUP BY booking.id;";


    @Override
    public boolean save(Collection t) {
        return false;
    }

    @Override
    public Collection getAll() {
        return List.of();
    }

    @Override
    public void delete(long flightId) {

    }

    @Override
    public Optional findOneBy(Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public Collection findAllBy(Predicate predicate) {
        return List.of();
    }
}
