package com.inm429.ecommerce.Controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.firebase.auth.FirebaseAuthException;
import com.inm429.ecommerce.Repository.UserRepository;
import com.inm429.ecommerce.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

}
