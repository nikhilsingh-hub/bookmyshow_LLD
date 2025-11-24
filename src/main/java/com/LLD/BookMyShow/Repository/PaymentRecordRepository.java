package com.LLD.BookMyShow.Repository;

import com.LLD.BookMyShow.Models.Booking;
import com.LLD.BookMyShow.Models.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRecordRepository  extends JpaRepository<PaymentRecord, String> {
}
