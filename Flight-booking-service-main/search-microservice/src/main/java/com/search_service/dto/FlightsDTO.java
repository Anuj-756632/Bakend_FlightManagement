package com.search_service.dto;

import com.search_service.entity.Flights;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightsDTO {

    private int flightId;

    @NotBlank @Size(min = 3, max = 30)
    private String flightName;

    @NotBlank @Size(min = 3, max = 30)
    private String origin;

    @NotBlank @Size(min = 3, max = 30)
    private String destination;

    @NotBlank
    private String departureTime;

    @NotBlank
    private String arrivalTime;

    @NotNull
    private Integer seats;

    @NotNull
    private Integer fare;

    public FlightsDTO(Flights f) {
        this.flightId = f.getFlightId();
        this.flightName = f.getFlightName();
        this.origin = f.getOrigin();
        this.destination = f.getDestination();
        this.departureTime = f.getDepartureTime();
        this.arrivalTime = f.getArrivalTime();
        this.seats = f.getSeats();
        this.fare = f.getFare();
    }
}
