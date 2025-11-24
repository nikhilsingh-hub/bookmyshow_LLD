package com.LLD.BookMyShow.Services.Implementations;

import com.LLD.BookMyShow.Models.PaymentRecord;
import com.LLD.BookMyShow.Repository.PaymentRecordRepository;
import com.LLD.BookMyShow.Services.Interfaces.PaymentService;
import com.LLD.BookMyShow.Services.PaymentStrategies.CardPaymentStrategy;
import com.LLD.BookMyShow.Services.PaymentStrategies.PaymentStrategy;
import com.LLD.BookMyShow.Services.PaymentStrategies.PaymentStrategyRegistry;
import com.LLD.BookMyShow.Services.PaymentStrategies.UPIPaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentStrategyRegistry paymentStrategyRegistry;

    @Autowired
    private PaymentRecordRepository paymentRecordRepository;

    @Override
    public PaymentRecord makePayment(double amount, String paymentMethod) {
        PaymentStrategy strategy = paymentStrategyRegistry.getStrategy(paymentMethod.toUpperCase());

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }

        PaymentRecord paymentRecord = strategy.pay(amount);
        return paymentRecordRepository.save(paymentRecord);
    }
}
