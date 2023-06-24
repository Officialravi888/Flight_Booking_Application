package com.example.service.impl;

import com.example.model.Flight;
import com.example.repository.FlightRepo;
import com.example.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepo flightRepo;
    public FlightServiceImpl(FlightRepo flightRepo){
        super();
        this.flightRepo=flightRepo;
    }
    @Override
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    @Override
    public Flight getFLightById(Integer id) {
        return flightRepo.findById(id).get();
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    @Override
    public void deleteFlightById(Integer id) {
        flightRepo.deleteById(id);
    }
}
