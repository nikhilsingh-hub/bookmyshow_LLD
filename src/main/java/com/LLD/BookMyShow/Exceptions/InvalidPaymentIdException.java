package com.LLD.BookMyShow.Exceptions;

public class InvalidPaymentIdException extends RuntimeException {
    public InvalidPaymentIdException(String message) {
        super(message);
    }
}
