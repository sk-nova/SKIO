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

import com.skio.dto.ApiResponse;
import com.skio.dto.ProjectReqDto;
import com.skio.dto.ProjectRespDto;
import com.skio.models.Project;
import com.skio.services.ProjectService;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	

	
	public ProjectController() {
		System.out.println("in Project controller");
	}
	
	@GetMapping
	public List<ProjectRespDto> listAllProjects(){
		return projectService.getAllProjects();
	}
	
	@PostMapping
	public Project addProjectDetails(@RequestBody Project newProject) {
		return projectService.addProjectDetails(newProject);
	}
	
	@DeleteMapping("/{ProjectId}")
	public ResponseEntity<?> deleteProjectDetails(@PathVariable Long ProjectId){
		System.out.println("in del Project id: " + ProjectId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(projectService.deleteProjectDetails(ProjectId)));
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{ProjectId}")
	public ProjectReqDto getProjectDetails(@PathVariable Long ProjectId) {
		return projectService.getProjectDetails(ProjectId);
	}
	
	@PutMapping
	public Project updateProjectDetails(@RequestBody Project Project) {
		return projectService.updateProjectDetails(Project);
	}
}
