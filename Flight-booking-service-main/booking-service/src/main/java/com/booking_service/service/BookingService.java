package com.booking_service.service;

import com.booking_service.dto.BookingDetailsDTO;
import java.util.List;

public interface BookingService {
    List<BookingDetailsDTO> getBookingDetails();
    BookingDetailsDTO getBookingDetailsById(Integer id);
    BookingDetailsDTO newBooking(BookingDetailsDTO bookingDetailsDTO);
    BookingDetailsDTO updateBookingDetails(Integer id, BookingDetailsDTO bookingDetailsDTO);
    void deleteBookingDetailsById(Integer id);
    void deleteAll();
}