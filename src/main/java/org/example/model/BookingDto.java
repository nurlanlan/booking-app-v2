package org.example.model;

public class BookingDto {
    public final String passengerName;
    public final String passengerSurname;
    public final long ticketId; // dataType

    public BookingDto(String passengerName, String passengerSurname, long ticketId) {
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerSurname='" + passengerSurname + '\'' +
                ", ticketId=" + ticketId +
                '}';
    }
}
