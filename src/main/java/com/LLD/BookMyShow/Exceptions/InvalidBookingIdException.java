package com.LLD.BookMyShow.Exceptions;

public class InvalidBookingIdException extends RuntimeException {
    public InvalidBookingIdException(String message) {
        super(message);
    }
}
