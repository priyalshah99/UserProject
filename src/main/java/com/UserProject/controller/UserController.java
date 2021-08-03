package com.UserProject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.UserProject.models.UserModel;
import com.UserProject.response.UserResponse;
import com.UserProject.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/edit")
    public String editUser(@RequestParam(name="id") final String id, Model model) {
    	
    	UserResponse response = UserResponse.build(userService.fetchUser(Integer.parseInt(id)));
    	model.addAttribute("user",response);
    	return "update";
    }

    @PostMapping("/edit")
    public String updateUser(@RequestBody MultiValueMap map, Model model) {
    	UserModel user = new UserModel();
		user.setFirstName(map.getFirst("firstName").toString());
		user.setLastName(map.getFirst("lastName").toString());
		user.setCountryCode(map.getFirst("countryCode").toString());
		user.setContact(map.getFirst("contact").toString());
		 user.setEmail(map.getFirst("email").toString());
        userService.updateUser(Integer.parseInt(map.getFirst("id").toString()), user);
        return "successUpdate";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name="id") final String id, Model model) {
        userService.deleteUser(Integer.parseInt(id));
        return "successDelete";
    }

   

    @GetMapping("/userlist")
    public String fetchAll(Model model) {
    	
    	List<UserResponse> userlist = userService.fetchAll().stream().map(inc -> UserResponse.build(inc)).collect(Collectors.toList());
    	model.addAttribute("userlist",userlist);
    	return "userlist";
    }

}
