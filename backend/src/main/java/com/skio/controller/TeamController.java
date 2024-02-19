package com.skio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skio.services.TeamService;
import com.skio.dto.ApiResponse;
import com.skio.models.Team;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamController {
	@Autowired
	private TeamService teamServ;
	
	public TeamController() {
		System.out.println("In team controller");		
	}
	
	//get all teams
	@GetMapping
	public List<Team> listAllTeams(){
		return teamServ.getAllTeams();
	}
	
	//get team details by id
	@GetMapping("/{teamId")
	public Team getTeamDetails(@PathVariable Long teamId) {
		return teamServ.getById(teamId);
	}
	
	//add new Team
	@PostMapping
	public Team addTeamDetails(Team newTeam) {
		return teamServ.addTeamDetails(newTeam);
	}
	
	@PutMapping
	public Team updateTeamDetails(@RequestBody Team t) {
		return teamServ.updateTeamDetails(t);
	}
	
	@DeleteMapping("/{teamId}")
	public ResponseEntity<?> deleteTeamDetails(@PathVariable Long teamId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(teamServ.deleteTeamDetails(teamId)));
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
}
