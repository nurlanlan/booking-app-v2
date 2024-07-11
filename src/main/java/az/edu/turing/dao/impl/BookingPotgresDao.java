package az.edu.turing.dao.impl;

import az.edu.turing.dao.BookingDao;
import az.edu.turing.dao.DAO;
import az.edu.turing.entity.BookingEntity;

import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookingPotgresDao extends BookingDao {


    private static final String getBookingByIdSql = "SELECT * FROM booking WHERE id = ?;";
    private static final String createBookingSql = "INSERT INTO booking (flight_id) VALUES (?);";
    private static final String createPassengerNameSql = "INSERT INTO passenger (full_name) VALUES (?);";
    private static final String createBookingByPassengerIdSql = "INSERT INTO bookings_passengers (booking_id, passenger_id) VALUES (?, ?);";
    private static final String deleteBookingSql = "DELETE FROM booking WHERE id = ?;";
    private static final String deletePassengerNameSql = "DELETE FROM passenger WHERE id = ?;";
    private static final String getAllBookingSql = "SELECT booking.id, booking.flight_id, string_agg(passenger.full_name, ',') as passenger_name FROM booking JOIN bookings_passengers ON booking.id = bookings_passengers.booking_id JOIN passenger ON bookings_passengers.passenger_id = passenger.id GROUP BY booking.id;";


    @Override
    public boolean save(Collection<BookingEntity> bookings) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
             PreparedStatement query = conn.prepareStatement(createBookingSql, Statement.RETURN_GENERATED_KEYS)) {
            query.setLong(1, bookings.getFlightId());
            query.executeUpdate();
            ResultSet generatedKeys = query.getGeneratedKeys();
            if (generatedKeys.next()) {
                long bookingId = generatedKeys.getLong(1);
                for (String passengerName : bookings.getPassengerNames()) {
                    PreparedStatement queryPassenger = conn.prepareStatement(createPassengerNameSql, Statement.RETURN_GENERATED_KEYS);
                    queryPassenger.setString(1, passengerName);
                    queryPassenger.executeUpdate();
                    ResultSet passengerKeys = queryPassenger.getGeneratedKeys();
                    if (passengerKeys.next()) {
                        long passengerId = passengerKeys.getLong(1);
                        PreparedStatement queryBookingPassenger = conn.prepareStatement(createBookingByPassengerIdSql);
                        queryBookingPassenger.setLong(1, bookingId);
                        queryBookingPassenger.setLong(2, passengerId);
                        queryBookingPassenger.executeUpdate();
                    }
                }
                PreparedStatement queryFlight = conn.prepareStatement("UPDATE flight SET free_seats = free_seats - (SELECT COUNT(*) FROM bookings_passengers WHERE booking_id = ?) WHERE id = ?;");
                queryFlight.setLong(1, bookingId);
                queryFlight.setLong(2, bookings.getFlightId());
                queryFlight.executeUpdate(); // NECE ELEYEK KI BU COLLECTION QEBUL ETSE DE OZELLIKLERDEN ISTIFADE OLUNAN BILSIN
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Collection<BookingEntity> getAll() {
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