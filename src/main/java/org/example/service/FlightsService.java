package org.example.service;

import org.example.dao.FlightsDao;

public class FlightsService {
    private final FlightsDao flightDAO;

    public FlightsService(FlightsDao flightDAO) {
        this.flightDAO = flightDAO;
    }

}
