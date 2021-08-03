package com.UserProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UserProject.models.UserModel;
import com.UserProject.request.UserRequest;
import com.UserProject.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("registration", new UserRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody final MultiValueMap  map,Model model) {
		
		UserModel user = new UserModel();
		user.setFirstName(map.getFirst("firstName").toString());
		user.setLastName(map.getFirst("lastName").toString());
		user.setCountryCode(map.getFirst("countryCode").toString());
		user.setContact(map.getFirst("contact").toString());
		 user.setEmail(map.getFirst("email").toString());
		 user.setPassword(map.getFirst("password").toString());
		 userService.saveUser(user);
		return "successRegistration";
	}
}
