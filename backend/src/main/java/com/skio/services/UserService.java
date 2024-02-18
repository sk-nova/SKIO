package com.skio.services;

import java.util.List;

import com.skio.dto.UserRespDto;
import com.skio.models.User;

public interface UserService {
	
	List<UserRespDto> getAllUsers();

	User addUserDetails(User newUser);

}
