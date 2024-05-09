package az.edu.turing.service;

import az.edu.turing.dao.FlightsDao;

public class FlightsService {
    private final FlightsDao flightDAO;

    public FlightsService(FlightsDao flightDAO) {
        this.flightDAO = flightDAO;
    }

}
