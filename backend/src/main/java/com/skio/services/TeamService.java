package com.skio.services;

import com.skio.dto.TeamRespDto;
import com.skio.models.Team;
import java.util.*;

public interface TeamService {

	List<TeamRespDto> getAllTeams();

	Team addTeamDetails(TeamRespDto newTeam);

	Team getById(Long teamId);

	Team updateTeamDetails(Team t);

	String deleteTeamDetails(Long teamId);

}
