package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.entity.UserRegister;

public interface UserService {
	
	UserRegister addUser(UserRegister userRegister);
	
	List<UserRegister> getAllUsers();
	
	Optional<UserRegister> getByUserId(Integer userId);
	
	String deleteUserById(Integer userId);
	
	String deleteAllUsers();

}
