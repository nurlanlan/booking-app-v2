package az.edu.turing.contoller;

import az.edu.turing.entity.FlightsEntity;
import az.edu.turing.model.FlightsDto;
import az.edu.turing.service.FlightsService;
import az.edu.turing.service.impl.FlightsServiceImpl;

import java.time.LocalDateTime;
import java.util.*;

public class FlightsController {
    private final FlightsService flightService;

    public FlightsController(FlightsService flightService) {
        this.flightService = flightService;
    }

    public void createFlights(FlightsDto flightsDto) {
        flightService.createFlights(flightsDto);
    }

    public Collection<FlightsDto> getAllFlights() {
        return flightService.getAllFlights();
    }

    public List<FlightsDto> getAllFlightsByLocation(String location) {
        return flightService.getAllFlightsByLocation(location);
    }
    public List<FlightsDto> getAllFlightsByDestination(String destination) {
        return flightService.getAllFlightsByDestination(destination);
    }

    public List<FlightsDto> getAllFlightsByFlightId(long flightId) {
        return flightService.getAllFlightsByFlightId(flightId);
    }

    public Optional<FlightsDto> getOneFlightByFlightId(long flightId) {
        return flightService.getOneFlightByFlightId(flightId);
    }
    public List<FlightsDto> getOnlineBoard(String location, LocalDateTime dateTime) {
        return flightService.flightsInNext24Hours(location, dateTime);
    }
}
