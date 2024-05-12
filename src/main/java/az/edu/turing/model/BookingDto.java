package az.edu.turing.model;

import java.util.List;

public class BookingDto {
    private static long MAX_ID = 0;
    private long ticketId;
    private long flightId;
    private List<String> passengerNames;

    public BookingDto() {
    }

    public BookingDto(long ticketId, long flightId, List<String> passengerNames) {
        this.ticketId = ++MAX_ID;
        this.flightId = flightId;
        this.passengerNames = passengerNames;

    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public List<String> getPassengerNames() {
        return passengerNames;
    }

    public void setPassengerNames(List<String> passengerNames) {
        this.passengerNames = passengerNames;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "ticketId=" + ticketId +
                ", flightId=" + flightId +
                ", passengerNames=" + passengerNames +
                '}';
    }
}
