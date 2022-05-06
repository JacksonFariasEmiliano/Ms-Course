package com.jkn.hrpayroll.service;

import com.jkn.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("Jack", 340.0, days);
    }
}

