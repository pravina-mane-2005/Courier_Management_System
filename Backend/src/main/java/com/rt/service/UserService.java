package com.rt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rt.entity.CourierTracking;
import com.rt.entity.User;
import com.rt.repository.CourierRepository;
import com.rt.repository.CourierTrackingRepository;
import com.rt.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository userRepo;

// Register
public User register(User user) {
    return userRepo.save(user);
}

// Login
public User login(String email, String password) {

    User user = userRepo.findByEmail(email);

    if(user != null && user.getPassword().equals(password)) {
        return user;
    }

    return null;
}

// Role check (Admin / Staff / Customer)
public String getUserRole(String email, String password) {

    User user = userRepo.findByEmail(email);

    if(user != null && user.getPassword().equals(password)) {

        if(user.getRole() != null){
            return user.getRole().getRoleName();
        }

    }

    return null;
}
// Get all users
public List<User> getAllUsers() {
    return userRepo.findAll();
}

// Get only customers
public List<User> getCustomers() {
    return userRepo.findByRoleRoleName("CUSTOMER");
}

// Get only staff
public List<User> getStaff() {
    return userRepo.findByRoleRoleName("STAFF");
}

@Autowired

private CourierTrackingRepository courierTrackingRepo; 
private CourierRepository courierRepo; // Add this
@Transactional
public void deleteUserById(int id) {
    User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

    boolean hasCouriers = courierRepo.existsBySender(user); // CourierRepository
    if(hasCouriers){
        throw new RuntimeException("Cannot delete user: User has sent couriers");
    }

    // Nullify updatedBy in tracking
    List<CourierTracking> trackingList = courierTrackingRepo.findByUpdatedBy(user);
    trackingList.forEach(c -> c.setUpdatedBy(null));
    courierTrackingRepo.saveAll(trackingList);

    userRepo.delete(user);
}

}

