package com.booking_service.dto;

import com.booking_service.entity.BookingDetails;
import com.booking_service.entity.Flights;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailsDTO {

    private int bookingId;
    @NotBlank
    @Size(min = 3, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 30)
    private String lastName;
    @NotBlank
    @Size(min = 3, max = 30)
    private String gender;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNo;
    @NotNull
    private Integer requiredSeats;
    private int flightId;
    private Flights flights;
    private LocalDateTime bookedOn;
    private LocalDateTime updatedOn;

    public BookingDetailsDTO(BookingDetails bookingDetails) {
        this.bookingId = bookingDetails.getBookingId();
        this.firstName = bookingDetails.getFirstName();
        this.lastName = bookingDetails.getLastName();
        this.gender = bookingDetails.getGender();
        this.email = bookingDetails.getEmail();
        this.phoneNo = bookingDetails.getPhoneNo();
        this.requiredSeats = bookingDetails.getRequiredSeats();
        this.flightId = bookingDetails.getFlightId();
        this.flights = bookingDetails.getFlights();
        this.bookedOn = bookingDetails.getBookedOn();
        this.updatedOn = bookingDetails.getUpdatedOn();
    }
}


//
//{
//        "bookingId": 1,
//        "firstName": "Abhishek",
//        "lastName": "Sen",
//        "gender": "Male",
//        "email":"abhisheksen70677@gmail.com",
//        "phone": "7067706367",
//        "requiredSeats": 1,
//        "flightId": 2
//        }