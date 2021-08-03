package com.UserProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UserProject.request.LoginRequest;
import com.UserProject.response.LoginResponse;
import com.UserProject.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
    	model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody final MultiValueMap  map, Model model) {
    	LoginResponse response=userService.validateUser(map.getFirst("email").toString(), map.getFirst("password").toString());
    	if(response==null) {
    		return "login";
    	}
    	model.addAttribute("name", response.getName());
    	model.addAttribute("id",String.valueOf(response.getId()));
    	return "account";
    }
}