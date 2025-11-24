package com.LLD.BookMyShow.Controllers;


import com.LLD.BookMyShow.DTOs.BookingDTO.BookingRequestDTO;
import com.LLD.BookMyShow.DTOs.BookingDTO.BookingResponseDTO;
import com.LLD.BookMyShow.DTOs.BookingDTO.FinalBookRequestDTO;
import com.LLD.BookMyShow.DTOs.ResponseType;
import com.LLD.BookMyShow.Models.Booking;
import com.LLD.BookMyShow.Services.Interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Book")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping
    public BookingResponseDTO blockSeats(@RequestBody BookingRequestDTO req){
        BookingResponseDTO res = new BookingResponseDTO();
        try{
            Booking booking = bookingService.bookSeats(req.getUserId(), req.getSeatIds());
            res.setResponseType(ResponseType.SUCCESS);
            res.setBooking(booking);
        } catch (Exception e) {
            System.out.println("Error booking seats: "+e);
            res.setResponseType(ResponseType.FAILURE);
        }
        return res;
    }

    @PostMapping("/finalBook")
    public BookingResponseDTO finaliseSeats(@RequestBody FinalBookRequestDTO req){
        BookingResponseDTO res = new BookingResponseDTO();
        try{
            Booking booking = bookingService.bookSeats(req.getBookingId(), req.getPaymentIds());
            res.setResponseType(ResponseType.SUCCESS);
            res.setBooking(booking);
        } catch (Exception e) {
            System.out.println("Error booking seats: "+e);
            res.setResponseType(ResponseType.FAILURE);
        }
        return res;
    }

}
