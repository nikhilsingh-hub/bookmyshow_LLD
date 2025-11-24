package com.LLD.BookMyShow.Controllers;

import com.LLD.BookMyShow.DTOs.PaymentDTO.PaymentRequestDTO;
import com.LLD.BookMyShow.DTOs.PaymentDTO.PaymentResponseDTO;
import com.LLD.BookMyShow.Models.PaymentRecord;
import com.LLD.BookMyShow.Services.Interfaces.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponseDTO makePayment(@RequestBody PaymentRequestDTO request) {
        PaymentRecord paymentRecord = paymentService.makePayment(request.getAmount(), request.getPaymentMethod());
        return convertToDTO(paymentRecord);
    }

    private PaymentResponseDTO convertToDTO(PaymentRecord paymentRecord) {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setPaymentId(paymentRecord.getId());
        response.setAmount(paymentRecord.getAmount());
        response.setPaymentStatus(paymentRecord.getPaymentStatus());
        response.setTransactionId(paymentRecord.getTransactionId());
        return response;
    }
}
