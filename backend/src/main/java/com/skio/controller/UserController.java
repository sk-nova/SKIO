package com.skio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

import com.skio.dto.UserRespDto;
import com.skio.models.User;
import com.skio.services.UserService;

@RestController
@RequestMapping("/users")
//@CrossOrigin
public class UserController {
	@Autowired(required = true)
	private UserService userServ;
	
	public UserController() {
		System.out.println("in user controller");
	}
	
	@GetMapping
	public List<UserRespDto> listAllUsers(){
		return userServ.getAllUsers();
	}
	
	@PostMapping
	public User addUserDetails(@RequestBody User newUser) {
		return userServ.addUserDetails(newUser);
	}
	

	
}
