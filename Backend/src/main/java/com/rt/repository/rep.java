package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rt.entity.Payment;

public interface rep extends JpaRepository<Payment,Integer>{

}
