package com.LLD.BookMyShow.DTOs.PaymentDTO;

import com.LLD.BookMyShow.Models.PaymentStatus;
import lombok.Data;

@Data
public class PaymentResponseDTO {
    private String paymentId;
    private double amount;
    private PaymentStatus paymentStatus;
    private String transactionId;
}
