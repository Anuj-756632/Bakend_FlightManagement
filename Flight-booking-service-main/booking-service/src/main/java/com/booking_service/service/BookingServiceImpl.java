package com.booking_service.service;

import com.booking_service.dto.BookingDetailsDTO;
import com.booking_service.entity.BookingDetails;
import com.booking_service.exception.BookingIdNotFoundException;
import com.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightsInfo flightsInfo;

    @Override
    public List<BookingDetailsDTO> getBookingDetails() {
        return bookingRepository.findAll().stream()
                .map(BookingDetailsDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDetailsDTO getBookingDetailsById(Integer id) {
        BookingDetails booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingIdNotFoundException("Booking not found for id: " + id));
        return new BookingDetailsDTO(booking);
    }

    @Override
    public BookingDetailsDTO newBooking(BookingDetailsDTO dto) {
        BookingDetails booking = new BookingDetails(dto);
        booking.setFlights(flightsInfo.getFlightDetails(dto.getFlightId()));
        booking.bookedTime();
        booking.updatedTime();
        return new BookingDetailsDTO(bookingRepository.save(booking));
    }

    @Override
    public BookingDetailsDTO updateBookingDetails(Integer id, BookingDetailsDTO dto) {
        BookingDetails existing = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingIdNotFoundException("Booking not found for id: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setGender(dto.getGender());
        existing.setEmail(dto.getEmail());
        existing.setPhoneNo(dto.getPhoneNo());
        existing.setRequiredSeats(dto.getRequiredSeats());
        existing.setFlightId(dto.getFlightId());
        existing.setFlights(flightsInfo.getFlightDetails(dto.getFlightId()));
        existing.updatedTime();

        return new BookingDetailsDTO(bookingRepository.save(existing));
    }

    @Override
    public void deleteBookingDetailsById(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookingRepository.deleteAll();
    }
}
