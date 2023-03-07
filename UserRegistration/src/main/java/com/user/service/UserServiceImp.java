package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.UserRegister;
import com.user.exceptions.UserNotFoundException;
import com.user.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserRegister addUser(UserRegister userRegister) {
		return userRepo.save(userRegister);
		
	}
	
	@Override
	public List<UserRegister> getAllUsers(){
		return  (List<UserRegister>) userRepo.findAll();
	}
	
	@Override
	public Optional<UserRegister> getByUserId(Integer userId) {
		return userRepo.findById(userId);
	}
	
	@Override
	public String deleteUserById(Integer userId) {
		userRepo.deleteById(userId);	
		return "Deleted Successfully";
	}
	
	
	@Override
	public String deleteAllUsers() {
		userRepo.deleteAll();
		return "All Users deleted";
	}
	
	
	
}
