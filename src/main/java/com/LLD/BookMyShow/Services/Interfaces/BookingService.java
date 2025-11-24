package com.LLD.BookMyShow.Services.Interfaces;

import com.LLD.BookMyShow.Models.Booking;

import java.util.List;

public interface BookingService {
    public Booking bookSeats(String userId, List<String> seatIds);
    public Booking finaliseSeats(String bookingId, List<String> paymentIds);
}
