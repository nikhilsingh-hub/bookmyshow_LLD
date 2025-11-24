package com.LLD.BookMyShow.Models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PaymentRecord extends BaseClass{
    private String transactionId;
    private double amount;
    private PaymentStatus paymentStatus;
}
