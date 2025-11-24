package com.LLD.BookMyShow.DTOs.BookingDTO;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO {
    private String userId;
    private List<String> seatIds;
}
