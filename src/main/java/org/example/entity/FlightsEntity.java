package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public final class FlightsEntity {
    private final LocalDateTime dateTime;
    private final long flightsId;
    private final String destination;
    private final int seats;

    public FlightsEntity(LocalDateTime dateTime, long flightsId, String destination, int seats) {
        this.dateTime = dateTime;
        this.flightsId = flightsId;
        this.destination = destination;
        this.seats = seats;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public long getFlightsId() {
        return flightsId;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsEntity that = (FlightsEntity) o;
        return flightsId == that.flightsId && seats == that.seats && Objects.equals(dateTime, that.dateTime) && Objects.equals(destination, that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime, flightsId, destination, seats);
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "dateTime=" + dateTime +
                ", flightsId=" + flightsId +
                ", destination='" + destination + '\'' +
                ", seats=" + seats +
                '}';
    }
}
