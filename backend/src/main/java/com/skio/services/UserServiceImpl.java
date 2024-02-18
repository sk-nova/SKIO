package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.skio.dao.UserDao;
import com.skio.dto.UserRespDto;
import com.skio.models.User;

public class UserServiceImpl implements UserService {
		
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<UserRespDto> getAllUsers() {
		return userDao.findAll()
				.stream()
				.map(e -> mapper.map(e, UserRespDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public User addUserDetails(User newUser) {
		return userDao.save(newUser);
		//return detached entity to the User
	}
	
	

}
