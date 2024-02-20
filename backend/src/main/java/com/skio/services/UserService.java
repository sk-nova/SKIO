package com.skio.services;

import java.util.List;

import com.skio.dto.UserReqDto;
import com.skio.dto.UserRespDto;
import com.skio.models.User;

public interface UserService {
	
	List<UserRespDto> getAllUsers();

	UserReqDto addUserDetails(UserReqDto newUser);

	String deleteUserDetails(Long userId);

	User getUserDetails(Long userId);

	User updateUserDetails(UserReqDto user);

}
