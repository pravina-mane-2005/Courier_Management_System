package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rt.entity.CourierTracking;
import com.rt.service.TrackingService;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
@CrossOrigin(origins = "*")
public class TrackingController {

@Autowired
private TrackingService trackingService;

@GetMapping("/{trackingNumber}")
public List<CourierTracking> trackCourier(@PathVariable String trackingNumber){
    return trackingService.trackCourier(trackingNumber);
}

@PostMapping("/update")
public CourierTracking updateStatus(@RequestBody CourierTracking tracking){
    return trackingService.updateStatus(tracking);
}

}