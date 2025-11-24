package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeat  extends BaseClass{
    @ManyToOne
    private Seat seat;
    @ManyToOne
    private Show show;
    @Enumerated
    private  ShowSeatType showSeatType;
    @Enumerated
    private SeatStatus seatStatus;
    private double price;
}
