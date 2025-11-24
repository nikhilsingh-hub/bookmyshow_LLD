package com.LLD.BookMyShow.DTOs.BookingDTO;

import lombok.Data;

import java.util.List;

@Data
public class FinalBookRequestDTO {
    String bookingId;
    List<String> paymentIds;
}
