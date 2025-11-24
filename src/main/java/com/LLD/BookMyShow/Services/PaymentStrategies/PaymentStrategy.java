package com.LLD.BookMyShow.Services.PaymentStrategies;

import com.LLD.BookMyShow.Models.PaymentRecord;

public interface PaymentStrategy {
    PaymentRecord pay(double amount);
    String getPaymentMethodName();
}
