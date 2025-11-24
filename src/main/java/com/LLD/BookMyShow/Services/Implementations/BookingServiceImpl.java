package com.LLD.BookMyShow.Services.Implementations;

import com.LLD.BookMyShow.Exceptions.*;
import com.LLD.BookMyShow.Models.*;
import com.LLD.BookMyShow.Repository.BookingRepository;
import com.LLD.BookMyShow.Repository.PaymentRecordRepository;
import com.LLD.BookMyShow.Repository.ShowSeatRepository;
import com.LLD.BookMyShow.Repository.UserRepository;
import com.LLD.BookMyShow.Services.Interfaces.BookingService;
import com.zaxxer.hikari.util.IsolationLevel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PaymentRecordRepository paymentRecordRepository;

    @Override
    @Transactional
    public Booking bookSeats(String userId, List<String> seatIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new InvalidUserIdException("User does not exist"));

        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);

        if(showSeats.size() != seatIds.size()) throw new InvalidSeatIdException("Invalid seat id provided");

        boolean isAllAvailable = showSeats.stream().allMatch(x -> x.getSeatStatus().equals(SeatStatus.AVAILABLE));

        if(!isAllAvailable) throw new SeatBlockedException("Few seats are not available for booking");

        List<ShowSeat> toBookSeats = showSeats.stream().peek(x-> x.setSeatStatus(SeatStatus.BLOCKED)).toList();

        // save seats
        List<ShowSeat> bookedSeats = showSeatRepository.saveAll(toBookSeats);

        // Return booking of these seats
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setPaymentStatus(PaymentStatus.PENDING);
        booking.setShowSeatList(bookedSeats);
        booking.setShow(showSeats.get(0).getShow());

        return bookingRepository.save(booking);
    }

    @Override
    public Booking finaliseSeats(String bookingId, List<String> paymentIds){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new InvalidBookingIdException("Invalid booking id"));

        List<PaymentRecord> paymentRecordList = paymentRecordRepository.findAllById(paymentIds);

        if(paymentRecordList.size() != paymentIds.size()) throw new InvalidPaymentIdException("Invalid payment id");

        booking.setPaymentRecord(paymentRecordList);
        booking.setPaymentStatus(PaymentStatus.COMPLETED);
        return bookingRepository.save(booking);
    }
}
