package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.TeamDao;
import com.skio.dto.TeamRespDto;
import com.skio.models.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<TeamRespDto> getAllTeams() {
		
		return teamDao.findAll()
				.stream()
				.map(t -> mapper.map(t, TeamRespDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public Team getById(Long teamId) {
		return teamDao.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Invalid team id!!!"));
	}
	
	@Override
	public Team addTeamDetails(TeamRespDto newTeam) {
		// TODO Auto-generated method stub
		Team team = mapper.map(newTeam,Team.class);
		return teamDao.save(team);
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
