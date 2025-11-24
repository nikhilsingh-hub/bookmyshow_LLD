package com.LLD.BookMyShow.Services.Interfaces;

import com.LLD.BookMyShow.Models.PaymentRecord;

public interface PaymentService {
    PaymentRecord makePayment(double amount, String paymentMethod);
}
