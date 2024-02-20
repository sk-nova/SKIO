package com.skio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skio.dto.ApiResponse;
import com.skio.dto.UserReqDto;
import com.skio.dto.UserRespDto;
import com.skio.models.User;
import com.skio.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
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
	public UserReqDto addUserDetails(@RequestBody UserReqDto newUser) {
		return userServ.addUserDetails(newUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable Long userId){
		System.out.println("in del user id: " + userId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(userServ.deleteUserDetails(userId)));
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{userId}")
	public UserRespDto getUserDetails(@PathVariable Long userId) {
		return userServ.getUserDetails(userId);
	}
	
	@PutMapping
	public User updateUserDetails(@RequestBody UserReqDto user) {
		return userServ.updateUserDetails(user);
	}
	
}
