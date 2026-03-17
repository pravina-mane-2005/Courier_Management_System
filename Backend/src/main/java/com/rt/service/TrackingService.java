package com.rt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Courier;
import com.rt.entity.CourierTracking;
import com.rt.repository.CourierRepository;
import com.rt.repository.CourierTrackingRepository;

import java.util.Date;
import java.util.List;

@Service
public class TrackingService {

@Autowired
private CourierRepository courierRepo;

@Autowired
private CourierTrackingRepository trackingRepo;
public List<CourierTracking> trackCourier(String trackingNumber){

    Courier courier = courierRepo.findByTrackingNumber(trackingNumber);

    if(courier == null){
        System.out.println("Courier not found for: " + trackingNumber);
        return List.of();
    }

    return trackingRepo.findByCourier(courier);
}
public CourierTracking updateStatus(CourierTracking tracking){

    tracking.setUpdatedAt(new Date());

    // Default location set
    if(tracking.getLocation() == null){
        tracking.setLocation("In Transit Hub");
    }

    return trackingRepo.save(tracking);
}
}