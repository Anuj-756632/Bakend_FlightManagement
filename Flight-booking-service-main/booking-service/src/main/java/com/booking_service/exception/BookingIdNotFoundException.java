package com.booking_service.exception;

public class BookingIdNotFoundException extends RuntimeException {

    public BookingIdNotFoundException (String message) {
        super(message);
    }
}
