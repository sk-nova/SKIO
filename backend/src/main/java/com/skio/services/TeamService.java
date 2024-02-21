package com.skio.services;

import com.skio.dto.TeamReqDto;
import com.skio.dto.TeamRespDto;
import com.skio.models.Team;
import java.util.*;

public interface TeamService {

	List<TeamReqDto> getAllTeams();

	Team addTeamDetails(TeamReqDto newTeam);

	TeamReqDto getById(Long teamId);

	TeamRespDto updateTeamDetails(TeamRespDto t);

	String deleteTeamDetails(Long teamId);

}
