package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.ProjectDao;
import com.skio.dao.TeamDao;
import com.skio.dto.BugRespDto;
import com.skio.dto.ProjectReqDto;
import com.skio.dto.ProjectRespDto;
import com.skio.dto.UserRespDto;
import com.skio.models.Project;
import com.skio.models.Team;
import com.skio.models.User;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TeamDao teamDao;
	
	@Override
	public List<ProjectRespDto> getAllProjects() {
		List<ProjectRespDto> response = projectDao.findAll().stream().map(this::mapProjecToProjectRespDto)
				.collect(Collectors.toList());

		return response;
	}
	
	private ProjectRespDto mapProjecToProjectRespDto(Project project) {
	    ProjectRespDto projectRespDto = mapper.map(project, ProjectRespDto.class);

	    // Set the team_id from the User's Team entity
	    if (project.getTeam() != null) {
	        projectRespDto.setTeamId(project.getTeam().getId());
	    }

	    return projectRespDto;
	}

	@Override
	public ProjectRespDto addProjectDetails(ProjectRespDto newProject) {
		Project project = mapper.map(newProject, Project.class);
		Team team = teamDao.findById(newProject.getTeamId())
				.orElseThrow(() -> new ResourceNotFoundException("Team not found"));
		project.setTeam(team);
		ProjectRespDto response = mapper.map(projectDao.save(project), ProjectRespDto.class);
		return response;
		// return detached entity to the Project
	}

	@Override
	public String deleteProjectDetails(Long projectId) {
		// TODO Auto-generated method stub
		if (projectDao.existsById(projectId)) {
			projectDao.deleteById(projectId);
			return "Project deleted successfully";
		}
		throw new ResourceNotFoundException("Project details cannot be deleted");
	}

	@Override
	public ProjectReqDto getProjectDetails(Long projectId) {
		Project p = projectDao.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Project Id!!"));
		ProjectReqDto response = mapper.map(p, ProjectReqDto.class);
		response.setTeamId(p.getTeam().getId());
		
		List<BugRespDto> bugsFound = p.getBugsFound().stream().map(b -> mapper.map(b, BugRespDto.class)).collect(Collectors.toList());
		response.setBugsFound(bugsFound);
		return response;
	}

	@Override
	public Project updateProjectDetails(Project project) {
		// TODO Auto-generated method stub
		return projectDao.save(project);
	}

}
