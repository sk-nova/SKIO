package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.TeamDao;
import com.skio.dao.UserDao;
import com.skio.dto.UserReqDto;
import com.skio.dto.UserRespDto;
import com.skio.models.Team;
import com.skio.models.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private TeamDao teamDao;
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
	public User addUserDetails(UserReqDto newUser) {
		
		User user = mapper.map(newUser, User.class); 
		Team team = teamDao.findById(newUser.getTeamId()).orElseThrow(() -> new ResourceNotFoundException("Team not found"));
		team.addUser(user);
		return userDao.save(user);
		
		//return detached entity to the User
	}
	
	@Override
	public String deleteUserDetails(Long userId) {
		// TODO Auto-generated method stub
		if(userDao.existsById(userId)) {
			userDao.deleteById(userId);
		}
		throw new ResourceNotFoundException("User details cannot be deleted");
	}
	
	@Override
	public User getUserDetails(Long userId) {
		return userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id!!"));
	}
	
	@Override
	public User updateUserDetails(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}
	
}
