package com.LLD.BookMyShow.Exceptions;

public class InvalidSeatIdException extends RuntimeException {
    public InvalidSeatIdException(String message) {
        super(message);
    }
}
