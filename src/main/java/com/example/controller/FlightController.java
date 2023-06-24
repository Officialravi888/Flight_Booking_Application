package com.example.controller;

import com.example.model.Flight;
import com.example.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;
    public FlightController(FlightService flightService){
        super();
        this.flightService=flightService;
    }
    @GetMapping("/flights")
    public String listFlights(Model model){
        model.addAttribute("flights",flightService.getAllFlights());
        return "flights";
    }
    @GetMapping("/flights/new")
    public  String createFlightFrom(Model model){
        Flight flight=new Flight();
        model.addAttribute("flight",flight);
        return "createflight";
    }
    @PostMapping("/flights")
    public String saveFlight(@ModelAttribute("flight") Flight flight){
        flightService.saveFlight(flight);
        return "redirect:/flights";
    }
    @GetMapping("/flights/edit/{id}")
    public String editFlightFrom(@PathVariable Integer id, Model model){
        model.addAttribute("flight",flightService.getFLightById(id));
        return "editFlight";
    }
    @PostMapping("/flights/{id}")
    public String updateFlight(@PathVariable Integer id, @ModelAttribute("flight") Flight flight,
     Model model){

        //get Flight from database id
        Flight existingFlight=flightService.getFLightById(id);
        existingFlight.setId(id);
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setFlightName(flight.getFlightName());
        existingFlight.setFromLocation(flight.getFromLocation());
        existingFlight.setBooking(flight.getBooking());
        existingFlight.setDuration(flight.getDuration());

        //save update flight obj
        flightService.updateFlight(existingFlight);
        return "redirect:/flights";

    }
    // delete method hendel
    @GetMapping("/flights/{id}")
    public String deleteFlight(@PathVariable Integer id ){
        flightService.deleteFlightById(id);
        return "redirect:/flights";
    }

}
