package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserRegister;
import com.user.exceptions.UserNotFoundException;
import com.user.service.UserServiceImp;


@RestController
@RequestMapping("/userRegister")
public class UserController {
	@Autowired 
	UserServiceImp userSer;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addDetails(@RequestBody UserRegister user)
	{
		UserRegister obj=userSer.addUser(user);
		return new ResponseEntity<String>("User Registered Successfully with UserId"+obj.getUserId(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserRegister>> getDetails()
	{
		List<UserRegister> Response = userSer.getAllUsers();
		return new ResponseEntity<List<UserRegister>>(Response,HttpStatus.OK);
	}
	
	
	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<UserRegister> getUserId(@PathVariable("userId") Integer userId) {
		Optional<UserRegister> user= userSer.getByUserId(userId);
		if (user.isPresent()) {
			return new ResponseEntity<UserRegister>(user.get(), HttpStatus.OK);
		}else 
			throw new UserNotFoundException("User not exist with given id");
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteall() {
		return userSer.deleteAllUsers();
	}
	
	@DeleteMapping("/deleteUserById")
	public ResponseEntity<String> deleteUserById(@RequestParam("userId") Integer userId) {
		userSer.deleteUserById(userId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	

}
