package com.rt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rt.entity.DeliveryStaff;
import com.rt.repository.DeliveryStaffRepository;

@Service
public class DeliveryStaffService {

@Autowired
private DeliveryStaffRepository repo;

public List<DeliveryStaff> getAllStaff(){
    return repo.findAll();
}

public DeliveryStaff addStaff(DeliveryStaff staff){
    return repo.save(staff);
}

public DeliveryStaff updateStaff(int id, DeliveryStaff staff){

    DeliveryStaff s = repo.findById(id).orElse(null);

    if(s != null){
        s.setName(staff.getName());
        s.setPhone(staff.getPhone());
        s.setVehicleNumber(staff.getVehicleNumber());
        s.setArea(staff.getArea());
        s.setStatus(staff.getStatus());

        return repo.save(s);
    }

    return null;
}

public void deleteStaff(int id){
    repo.deleteById(id);
}




}