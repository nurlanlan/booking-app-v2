package az.edu.turing.model;

public class BookingDto {
    public String passengerName;
    public String passengerSurname;
    public long ticketId;
    // private FlightsEntity flight;

    public BookingDto( ) {
    }
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
