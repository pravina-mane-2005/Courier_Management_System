package com.rt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rt.entity.Payment;
import com.rt.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {

@Autowired
private PaymentService service;


@GetMapping
public List<Payment> getAllPayments(){

return service.getAllPayments();

}


@PostMapping
public Payment savePayment(@RequestBody Payment payment){

return service.savePayment(payment);

}

}