package az.edu.turing.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public final class FlightsEntity {
    public LocalDateTime departureDateTime;
    public String destination;
    public  int totalSeats;
    public  int bookedSeats;
    public long flightId;

    public FlightsEntity() {
    }

    public FlightsEntity(LocalDateTime departureDateTime, String destination, int totalSeats, int bookedSeats) {
        this.departureDateTime = departureDateTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
    }

    public FlightsEntity(LocalDateTime departureDateTime, String destination, int totalSeats, int bookedSeats, long flightId) {
        this.departureDateTime = departureDateTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.flightId = flightId;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public long getFlightId() {
        return flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsEntity that = (FlightsEntity) o;
        return totalSeats == that.totalSeats && bookedSeats == that.bookedSeats && flightId == that.flightId && Objects.equals(departureDateTime, that.departureDateTime) && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureDateTime, destination, totalSeats, bookedSeats, flightId);
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "departureDateTime=" + departureDateTime +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                ", flightId=" + flightId +
                '}';
    }
}
