package com.rt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rt.entity.DeliveryStaff;
import com.rt.service.DeliveryStaffService;

@RestController
	@RequestMapping("/api/staff")
	@CrossOrigin(origins = "*")
	public class DeliveryStaffController {

	    @Autowired
	    private DeliveryStaffService service;

	    @PostMapping
	    public DeliveryStaff addStaff(@RequestBody DeliveryStaff staff){
	        return service.addStaff(staff);
	    }

	    @GetMapping
	    public List<DeliveryStaff> getAllStaff(){
	        return service.getAllStaff();
	    }
	    @PutMapping("/{id}")
	    public DeliveryStaff updateStaff(@PathVariable int id,@RequestBody DeliveryStaff staff){
	        return service.updateStaff(id, staff);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteStaff(@PathVariable int id){
	        service.deleteStaff(id);
	        return "Deleted";
	    }
	    
}
