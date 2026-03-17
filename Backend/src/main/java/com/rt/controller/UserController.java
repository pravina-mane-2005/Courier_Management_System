package com.rt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.entity.User;
import com.rt.service.UserService;

@RestController
	@RequestMapping("/api/users")
	@CrossOrigin(origins = "*")
	public class UserController {

	    @Autowired
	    private UserService userService;

	    // Get all users (optional)
	    @GetMapping
	    public List<User> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    // Get all customers (Admin page use)
	    @GetMapping("/customers")
	    public List<User> getAllCustomers() {
	        return userService.getCustomers(); // returns only users with role "CUSTOMER"
	    }
	    @PostMapping("/login")
	    public User login(@RequestBody User user){

	        User u = userService.login(user.getEmail(), user.getPassword());

	        return u;
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable int id){
	        try {
	            userService.deleteUserById(id);
	            return ResponseEntity.ok("User deleted successfully");
	        } catch (RuntimeException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
}


