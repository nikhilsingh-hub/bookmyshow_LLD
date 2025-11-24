package com.LLD.BookMyShow.DTOs.PaymentDTO;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private double amount;
    private String paymentMethod;
}
