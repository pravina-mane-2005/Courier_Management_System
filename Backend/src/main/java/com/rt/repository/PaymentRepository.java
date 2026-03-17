package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rt.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}