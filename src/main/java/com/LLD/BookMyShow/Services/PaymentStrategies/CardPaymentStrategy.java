package com.LLD.BookMyShow.Services.PaymentStrategies;

import com.LLD.BookMyShow.Models.PaymentRecord;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentRecord pay(double amount) {
        // Simulate Card payment logic
        PaymentRecord paymentRecord = new PaymentRecord();
        paymentRecord.setAmount(amount);
        paymentRecord.setTransactionId(UUID.randomUUID().toString());
        // In a real app, we would integrate with a Card gateway here
        return paymentRecord;
    }

    @Override
    public String getPaymentMethodName() {
        return "CARD";
    }
}
