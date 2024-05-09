package az.edu.turing.model;

import java.time.LocalDateTime;

public class FlightsDto {
    public LocalDateTime departureDateTime;
    public String destination;
    public int totalSeats;
    public int bookedSeats;
    public long flightId;

    public FlightsDto( ) {
    }

    public FlightsDto(LocalDateTime departureDateTime, String destination, int totalSeats, int bookedSeats, long flightId) {
        this.departureDateTime = departureDateTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.flightId = flightId;
    }
    public FlightsDto(LocalDateTime departureDateTime, String destination, int totalSeats, int bookedSeats) {
        this.departureDateTime = departureDateTime;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
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
    public String toString() {
        return "FlightsDto{" +
                "departureDateTime=" + departureDateTime +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                ", flightId=" + flightId +
                '}';
    }
}
