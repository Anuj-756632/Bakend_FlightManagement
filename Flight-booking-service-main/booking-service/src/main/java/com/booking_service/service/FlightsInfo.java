package com.booking_service.service;

import com.booking_service.entity.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightsInfo {

    @Autowired
    private RestTemplate restTemplate;

    public Flights getFlightDetails(int flightId) {
        try {
            return restTemplate.getForObject("http://search-microservice/flights/get/" + flightId, Flights.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Flight not found with ID: " + flightId);
        } catch (Exception e) {
            throw new RuntimeException("Unable to contact flight service: " + e.getMessage());
        }
    }
}