package com.LLD.BookMyShow.Services.PaymentStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentStrategyRegistry {

    private Map<String, PaymentStrategy> paymentStrategies = new HashMap<>();

    @Autowired
    public PaymentStrategyRegistry(List<PaymentStrategy> strategies) {
        for (PaymentStrategy strategy : strategies) {
            paymentStrategies.put(strategy.getPaymentMethodName(), strategy);
        }
    }

    public PaymentStrategy getStrategy(String paymentMethod) {
        return paymentStrategies.get(paymentMethod);
    }
}
