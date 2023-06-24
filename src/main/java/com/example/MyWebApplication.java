package com.example;

import com.example.model.Flight;
import com.example.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}

	@Autowired
	private FlightRepo flightRepo;

	@Override
	public void run(String... args) throws Exception {

//		Flight flight1=new Flight(1,2542,"Air","mumbai","this is good flight","60 km");
//		flightRepo.save(flight1);
//		Flight flight2=new Flight(2,5723,"YE"," Gurugram","this is night suffer good","40 km");
//		flightRepo.save(flight2);

	}
}
