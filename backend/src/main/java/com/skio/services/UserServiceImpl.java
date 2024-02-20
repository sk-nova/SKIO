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
import com.skio.dto.BugRespDto;
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
				.map(this::mapUserToUserRespDto)
				.collect(Collectors.toList());
	}
	
	private UserRespDto mapUserToUserRespDto(User user) {
	    UserRespDto userRespDto = mapper.map(user, UserRespDto.class);

	    // Set the team_id from the User's Team entity
	    if (user.getTeam() != null) {
	        userRespDto.setTeamId(user.getTeam().getId());
	    }

	    return userRespDto;
	}

	@Override
	public UserReqDto addUserDetails(UserReqDto newUser) {

		User user = mapper.map(newUser, User.class);

//		user.getTeam().setNoOfMembers(user.getTeam().getNoOfMembers()+1);

		Team team = teamDao.findById(newUser.getTeamId())
				.orElseThrow(() -> new ResourceNotFoundException("Team not found"));

		user.setTeam(team);
//		team.addUser(user);

		UserReqDto userResp = mapper.map(userDao.save(user), UserReqDto.class);
//		
		return userResp;

		// return detached entity to the User
	}

	@Override
	public String deleteUserDetails(Long userId) {
		// TODO Auto-generated method stub
		if (userDao.existsById(userId)) {
			userDao.deleteById(userId);
		}
		throw new ResourceNotFoundException("User details cannot be deleted");
	}

	@Override
	public UserRespDto getUserDetails(Long userId) {
		User u = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id!!"));
		UserRespDto response = mapper.map(u, UserRespDto.class);
		response.setTeamId(u.getTeam().getId());
		List<BugRespDto> bugsReported = u.getReportedBugs()
										.stream()
										.map(b -> mapper.map(b, BugRespDto.class))
										.collect(Collectors.toList());
		response.setReportedBug(bugsReported);
		List<BugRespDto> bugsAssigned = u.getAssignedBugs()
										.stream()
										.map(b -> mapper.map(b, BugRespDto.class))
										.collect(Collectors.toList());
		response.setAssignedBug(bugsAssigned);
		
		return response;
	}

	@Override
	public User updateUserDetails(UserReqDto newUser) {
		// TODO Auto-generated method stub
		User user = mapper.map(newUser, User.class);
		return userDao.save(user);
	}

}
