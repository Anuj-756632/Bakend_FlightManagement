package com.search_service.entity;

import com.search_service.dto.FlightsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    @NotBlank
    @Size(min = 3, max = 30)
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

    public Flights(FlightsDTO dto) {
        this.flightName = dto.getFlightName();
        this.origin = dto.getOrigin();
        this.destination = dto.getDestination();
        this.departureTime = dto.getDepartureTime();
        this.arrivalTime = dto.getArrivalTime();
        this.seats = dto.getSeats();
        this.fare = dto.getFare();
    }
}
