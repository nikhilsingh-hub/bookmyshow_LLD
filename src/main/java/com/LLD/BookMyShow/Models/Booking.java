package com.LLD.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Booking extends BaseClass{
    @ManyToOne
    private User user;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeatList;
    @Enumerated
    private PaymentStatus paymentStatus;
    @OneToMany
    private List<PaymentRecord> paymentRecord;
}
