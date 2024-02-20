package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.TeamDao;
import com.skio.dto.TeamReqDto;
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
	public List<TeamReqDto> getAllTeams() {
		
		return teamDao.findAll()
				.stream()
				.map(t -> mapper.map(t, TeamReqDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public TeamReqDto getById(Long teamId) {
		Team team = teamDao.findById(teamId).orElseThrow(() -> new ResourceNotFoundException("Invalid team id!!!"));
		
		TeamReqDto teamResp = mapper.map(team, TeamReqDto.class);
		
		
		
		return teamResp;
	}
	
	@Override
	public Team addTeamDetails(TeamReqDto newTeam) {
		// TODO Auto-generated method stub
		Team team = mapper.map(newTeam,Team.class);
		return teamDao.save(team);
	}
	
	@Override
	public TeamRespDto updateTeamDetails(TeamRespDto t) {
		Team team = mapper.map(t, Team.class);
		teamDao.save(team);
		return t;
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
