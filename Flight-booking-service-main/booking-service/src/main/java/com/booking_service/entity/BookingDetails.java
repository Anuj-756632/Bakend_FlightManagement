package com.booking_service.entity;

import com.booking_service.dto.BookingDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNo;
    private Integer requiredSeats;
    private int flightId;

    @Transient
    private Flights flights;

    private LocalDateTime bookedOn;
    private LocalDateTime updatedOn;

    public BookingDetails(BookingDetailsDTO dto) {
        this.bookingId = dto.getBookingId();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.gender = dto.getGender();
        this.email = dto.getEmail();
        this.phoneNo = dto.getPhoneNo();
        this.requiredSeats = dto.getRequiredSeats();
        this.flightId = dto.getFlightId();
        this.flights = dto.getFlights();
        this.bookedOn = dto.getBookedOn();
        this.updatedOn = dto.getUpdatedOn();
    }

    public void bookedTime() {
        this.bookedOn = LocalDateTime.now();
    }

    public void updatedTime() {
        this.updatedOn = LocalDateTime.now();
    }
}