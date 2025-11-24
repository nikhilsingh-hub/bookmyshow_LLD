package com.LLD.BookMyShow.Exceptions;

public class InvalidBookingId extends RuntimeException {
    public InvalidBookingId(String message) {
        super(message);
    }
}
