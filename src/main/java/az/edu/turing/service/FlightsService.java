package az.edu.turing.service;

import az.edu.turing.dao.FlightsDao;
import az.edu.turing.entity.FlightsEntity;
import az.edu.turing.model.FlightsDto;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface FlightsService {
    void createFlights(FlightsDto flightsDto);

    Collection<FlightsDto> getAllFlights();

    List<FlightsDto> getAllFlightsByLocation(String location);

    List<FlightsDto> getAllFlightsByDestination(String destination);

    List<FlightsDto> getAllFlightsByFlightId(long flightId);

    Optional<FlightsDto> getOneFlightByFlightId(long flightId);
    List<FlightsDto> flightsInNext24Hours(String location,LocalDateTime dateTime);

    //List<FlightsDto> getAllFlightsBy(Predicate<FlightsDto> predicate);
    // Optional<FlightsDto> getOneFlightBy(Predicate<FlightsDto> predicate);
    //  void cancelFlight(int flightId);
}
