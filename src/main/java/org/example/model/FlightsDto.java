package org.example.model;

import java.time.LocalDateTime;

public class FlightsDto {
    public final LocalDateTime dateTime;
    public final long flightsId;
    public final String destination;
    public final int seats;

    public FlightsDto(LocalDateTime dateTime, long flightsId, String destination, int seats) {
        this.dateTime = dateTime;
        this.flightsId = flightsId;
        this.destination = destination;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "FlightsDto{" +
                "dateTime=" + dateTime +
                ", flightsId=" + flightsId +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                '}';
    }
}
