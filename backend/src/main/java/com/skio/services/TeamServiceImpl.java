package com.skio.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.TeamDao;
import com.skio.models.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
//	private ModelMapper mappper;

	
	@Override
	public List<Team> getAllTeams() {
		
		List<Team> teams = teamDao.findAll();
		return teams;
	}
	
	@Override
	public Team getById(Long teamId) {
		return teamDao.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Invalid team id!!!"));
	}
	
	@Override
	public Team addTeamDetails(Team newTeam) {
		// TODO Auto-generated method stub
		return teamDao.save(newTeam);
	}
	
	@Override
	public Team updateTeamDetails(Team t) {
		// TODO Auto-generated method stub
		return teamDao.save(t);
	}
	
	@Override
	public String deleteTeamDetails(Long teamId) {
		if (teamDao.existsById(teamId)) {
			teamDao.deleteById(teamId);
			return "Delete team details";
		}
		throw new ResourceNotFoundException("Team Cannot be deleted");
	}
	
}
