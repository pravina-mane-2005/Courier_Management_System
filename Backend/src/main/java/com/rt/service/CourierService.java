package com.rt.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Courier;
import com.rt.entity.CourierStatsDTO;
import com.rt.entity.CourierTracking;
import com.rt.entity.DeliveryStaff;
import com.rt.repository.CourierRepository;
import com.rt.repository.CourierTrackingRepository;
import com.rt.repository.UserRepository;

@Service
public class CourierService {

@Autowired
private CourierRepository repo;
@Autowired
private CourierTrackingRepository trackingRepo;

@Autowired
private UserRepository UserRepo;

public Courier bookCourier(Courier courier) {

    courier.setStatus("Booked");
    courier.setCreatedAt(new Date());

    String trackingNumber = "TRK" + System.currentTimeMillis();
    courier.setTrackingNumber(trackingNumber);

    Courier savedCourier = repo.save(courier);

    CourierTracking tracking = new CourierTracking();
    tracking.setCourier(savedCourier);
    tracking.setLocation(savedCourier.getSourceAddress());
    tracking.setStatus("Courier Booked");
    tracking.setUpdatedAt(new Date());
    tracking.setUpdatedBy(savedCourier.getSender());

    trackingRepo.save(tracking);

    return savedCourier;
}
public Courier assignStaff(int courierId, DeliveryStaff staff) {

    Courier courier = repo.findById(courierId).orElse(null);

    courier.setStaff(staff);
    courier.setStatus("Assigned");

    Courier updatedCourier = repo.save(courier);

    // Tracking record
    CourierTracking tracking = new CourierTracking();
    tracking.setCourier(updatedCourier);
    tracking.setLocation(updatedCourier.getSourceAddress());
    tracking.setStatus("Assigned to Delivery Staff");
    tracking.setUpdatedAt(new Date());

    trackingRepo.save(tracking);

    return updatedCourier;
}

public List<Courier> getMyCouriers(int senderId){

return repo.findBySender_Id(senderId);

}


public Courier trackCourier(String tracking){

return repo.findByTrackingNumber(tracking);

}
// --- Get all couriers (admin view) ---
public List<Courier> getAllCouriers() {
    return repo.findAll();
}

public CourierStatsDTO getCourierStats() {
    long totalUsers = UserRepo.count();                  // total users
    long totalCouriers = repo.countTotalCouriers(); // total couriers
    long pending = repo.countPending();             // pending
    long inProgress = repo.countInProgress();       // in progress

    return new CourierStatsDTO(totalUsers, totalCouriers, pending, inProgress);
}

public List<Courier> getCouriersByStaff(int staffId){
    return repo.findByStaff_Id(staffId);
}
}

