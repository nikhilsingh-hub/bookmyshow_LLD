package com.LLD.BookMyShow.DTOs.BookingDTO;

import com.LLD.BookMyShow.DTOs.ResponseType;
import com.LLD.BookMyShow.Models.Booking;
import lombok.Data;

@Data
public class BookingResponseDTO {
    private Booking booking;
    private ResponseType responseType;
}
