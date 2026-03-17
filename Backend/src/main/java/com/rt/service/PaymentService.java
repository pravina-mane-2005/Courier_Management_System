package com.rt.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Payment;
import com.rt.repository.PaymentRepository;

@Service
public class PaymentService {

@Autowired
private PaymentRepository repo;


public Payment savePayment(Payment payment){

payment.setPaymentDate(new Date());

return repo.save(payment);

}


public List<Payment> getAllPayments(){

return repo.findAll();

}

}