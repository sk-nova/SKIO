package com.skio.services;

import com.skio.models.Team;
import java.util.*;

public interface TeamService {

	List<Team> getAllTeams();

	Team addTeamDetails(Team newTeam);

	Team getById(Long teamId);

	Team updateTeamDetails(Team t);

	String deleteTeamDetails(Long teamId);

}
