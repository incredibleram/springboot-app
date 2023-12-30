package com.inm429.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.inm429.ecommerce.Model.User;
import com.inm429.ecommerce.Service.UserMetricsService;
import com.inm429.ecommerce.Service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMetricsService userMetricsService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
	
	@GetMapping("/user")
	public ResponseEntity<User> getUser(@RequestParam("email") String emailId) {
		return ResponseEntity.status(HttpStatus.OK)
		        .body(userService.getUser(emailId));
    }
	
	@GetMapping("/login")
	public int increaseCount() {
		userMetricsService.increaseCount();
		return 0;
    }
	
	@GetMapping("/getCount")
	public ResponseEntity<String> getCount() {
		String response = "{\"count\" : "+userMetricsService.getCurrentUsersCount()+"}";
		return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	@GetMapping("/logout")
	public int updateCount() {
		userMetricsService.decreaseCount();
		return 0;
    }
}
