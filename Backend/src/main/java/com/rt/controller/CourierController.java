package com.rt.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rt.entity.Courier;
import com.rt.entity.CourierStatsDTO;
import com.rt.entity.DeliveryStaff;
import com.rt.repository.CourierRepository;
import com.rt.repository.DeliveryStaffRepository;
import com.rt.service.CourierService;

@RestController
@RequestMapping("/api/couriers")
@CrossOrigin("*")
public class CourierController {

@Autowired
private CourierService service;
@Autowired
private CourierRepository  courierRepository;
@Autowired
private DeliveryStaffRepository staffRepository;

// BOOK COURIER
@PostMapping("/book")
public ResponseEntity<Courier> bookCourier(@RequestBody Courier courier){
    Courier saved = service.bookCourier(courier);
    return ResponseEntity.ok(saved); // Returns the saved courier including tracking number
}


// MY COURIERS
@GetMapping("/my/{senderId}")
public List<Courier> myCouriers(@PathVariable int senderId){

return service.getMyCouriers(senderId);

}

// TRACK COURIER
@GetMapping("/track/{tracking}")
public Courier trackCourier(@PathVariable String tracking){

return service.trackCourier(tracking);

}


@GetMapping("/all")
public List<Courier> getAllCouriers() {
    return service.getAllCouriers();
}
@PostMapping("/tracking/update")
public ResponseEntity<Courier> assignStaff(@RequestBody TrackingUpdateRequest req){
    Courier courier = courierRepository.findByTrackingNumber(req.getCourier().getTrackingNumber());
    
    if(courier != null){
        courier.setStatus(req.getStatus());

        if(req.getStaff() != null){
            DeliveryStaff staff = staffRepository.findById(req.getStaff().getId()).orElse(null);
            courier.setStaff(staff);

        }

        courierRepository.save(courier);
        return ResponseEntity.ok(courier);
    }

    return ResponseEntity.notFound().build();
}
@PutMapping("/assignStaff/{courierId}/{staffId}")
public Courier assignStaff(@PathVariable int courierId,
                           @PathVariable int staffId){

    DeliveryStaff staff = staffRepository.findById(staffId).orElse(null);

    return service.assignStaff(courierId, staff);
}

@GetMapping("/stats")
public CourierStatsDTO getCourierStats() {
    return service.getCourierStats();
}
@PostMapping("/tracking/cancel/{trackingNumber}")
public ResponseEntity<Courier> cancelCourier(@PathVariable String trackingNumber) {

    // Find the courier by tracking number
    Courier courier = courierRepository.findByTrackingNumber(trackingNumber);

    if (courier == null) {
        // Return 404 if not found
        return ResponseEntity.status(404).body(null);
    }

    // Set status to Cancelled
    courier.setStatus("Cancelled");

    // Optional: remove assigned staff
    courier.setStaff(null);

    // Save back to database
    courierRepository.save(courier);

    // Return updated courier
    return ResponseEntity.ok(courier);
}
@GetMapping("/{staffId}/couriers")
public List<Courier> getAssignedCouriers(@PathVariable int staffId){
    return service.getCouriersByStaff(staffId);
}
}