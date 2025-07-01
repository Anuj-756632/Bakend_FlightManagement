package com.search_service.controller;

import com.search_service.dto.FlightsDTO;
import com.search_service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public ResponseEntity<FlightsDTO> addFlight(@Valid @RequestBody FlightsDTO dto) {
        return ResponseEntity.ok(flightService.newFlight(dto));
    }

    @GetMapping("/getAll")
    public List<FlightsDTO> getAll() {
        return flightService.getFlights();
    }

    @GetMapping("/get/{id}")
    public FlightsDTO getById(@PathVariable Integer id) {
        return flightService.getFlight(id);
    }

    @GetMapping("/getByFromTo")
    public List<FlightsDTO> getByFromTo(@RequestParam String origin, @RequestParam String destination) {
        return flightService.flightByOriginAndDestination(origin, destination);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FlightsDTO> update(@PathVariable Integer id, @Valid @RequestBody FlightsDTO dto) {
        return new ResponseEntity<>(flightService.updateFlight(id, dto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        flightService.deleteFlight(id);
        return "Flight with ID: " + id + " deleted successfully.";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        flightService.deleteAll();
        return "All flights deleted successfully.";
    }
}
