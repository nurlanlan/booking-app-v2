package az.edu.turing.entity;

import java.util.Objects;

public final class BookingEntity {
    private String passengerName;
    private  String passengerSurname;
    private long ticketId;

    public BookingEntity( ) {
    }

    public BookingEntity(String passengerName, String passengerSurname, long ticketId) {
        this.passengerName = passengerName;
        this.passengerSurname = passengerSurname;
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public long getFlightsId() {
        return ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return ticketId == that.ticketId && Objects.equals(passengerName, that.passengerName) && Objects.equals(passengerSurname, that.passengerSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerName, passengerSurname, ticketId);
    }

    @Override
    public String toString() {
        return "BookingEntity{" +
                "passengerName='" + passengerName + '\'' +
                ", passengerSurname='" + passengerSurname + '\'' +
                ", ticketId=" + ticketId +
                '}';
    }
}
