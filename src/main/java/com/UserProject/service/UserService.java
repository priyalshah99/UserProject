package com.UserProject.service;

import java.util.List;

import com.UserProject.models.UserModel;
import com.UserProject.response.LoginResponse;

public interface UserService {

    void saveUser(UserModel user);

    List<UserModel> fetchAll();

    UserModel fetchUser(int  id);

    void deleteUser(int id);

    void updateUser(int id, UserModel user);
    
    LoginResponse validateUser(String email, String password);

}
