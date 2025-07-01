package com.search_service.service;

import com.search_service.dto.FlightsDTO;
import com.search_service.entity.Flights;
import com.search_service.exception.FlightNotFoundException;
import com.search_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<FlightsDTO> getFlights() {
        return flightRepository.findAll().stream().map(FlightsDTO::new).collect(Collectors.toList());
    }

    @Override
    public FlightsDTO getFlight(Integer id) {
        Flights flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + id));
        return new FlightsDTO(flight);
    }

    @Override
    public List<FlightsDTO> flightByOriginAndDestination(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination)
                .stream().map(FlightsDTO::new).collect(Collectors.toList());
    }

    @Override
    public FlightsDTO newFlight(FlightsDTO dto) {
        Flights flight = new Flights(dto);
        return new FlightsDTO(flightRepository.save(flight));
    }

    @Override
    public FlightsDTO updateFlight(Integer id, FlightsDTO dto) {
        Flights flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + id));

        if (dto.getFlightName() != null) flight.setFlightName(dto.getFlightName());
        if (dto.getOrigin() != null) flight.setOrigin(dto.getOrigin());
        if (dto.getDestination() != null) flight.setDestination(dto.getDestination());
        if (dto.getDepartureTime() != null) flight.setDepartureTime(dto.getDepartureTime());
        if (dto.getArrivalTime() != null) flight.setArrivalTime(dto.getArrivalTime());
        if (dto.getSeats() != null) flight.setSeats(dto.getSeats());
        if (dto.getFare() != null) flight.setFare(dto.getFare());

        return new FlightsDTO(flightRepository.save(flight));
    }

    @Override
    public void deleteFlight(Integer id) {
        Flights flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight not found with ID: " + id));
        flightRepository.delete(flight);
    }

    @Override
    public void deleteAll() {
        flightRepository.deleteAll();
    }
}
