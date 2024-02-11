package com.skio.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.skio.dao.TeamDao;
import com.skio.models.Team;

public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamdao;
	@Autowired
//	private ModelMapper mappper;

	
	@Override
	public List<Team> getAllTeams() {
		
		List<Team> teams = teamdao.findAll();
		return teams;
	}
	
	@Override
	public Team getById(Long teamId) {
		return teamdao.findById(teamId).orElseThrow();
	}
	
	@Override
	public Team addTeamDetails(Team newTeam) {
		// TODO Auto-generated method stub
		return teamdao.save(newTeam);
	}
	
	@Override
	public Team updateTeamDetails(Team t) {
		// TODO Auto-generated method stub
		return teamdao.save(t);
	}
	
	
}
