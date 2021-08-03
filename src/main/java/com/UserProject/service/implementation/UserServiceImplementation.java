package com.UserProject.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserProject.models.UserModel;
import com.UserProject.repository.UserRepository;
import com.UserProject.response.LoginResponse;
import com.UserProject.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public List<UserModel> fetchAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel fetchUser(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(int id, UserModel user) {
        UserModel u = userRepository.getOne(id);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setContact(user.getContact());
        u.setCountryCode(user.getCountryCode());

        userRepository.save(u);
    }

	@Override
	public LoginResponse validateUser(String email, String password) {
		
		UserModel u = userRepository.findByEmail(email);
		if (u != null) {
			
			if (u.getPassword().equals(password)) {
				LoginResponse response = new LoginResponse();
				response.setId(u.getUserId());
				response.setName(u.getFirstName() + " " + u.getLastName());
				return response;
			}
				
		}
		return null;
	}
}
