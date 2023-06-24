package com.example.service;

import com.example.model.Flight;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FlightService {
    List<Flight> getAllFlights();
    Flight saveFlight(Flight flight);
    //add method
    Flight getFLightById(Integer id);
    Flight updateFlight(Flight flight);
    void deleteFlightById(Integer id);
}
