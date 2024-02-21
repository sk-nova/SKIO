package com.skio.services;

import java.util.List;

import com.skio.dto.ProjectReqDto;
import com.skio.dto.ProjectRespDto;
import com.skio.models.Project;

public interface ProjectService {

	List<ProjectRespDto> getAllProjects();

	ProjectRespDto addProjectDetails(ProjectRespDto newProject);

	String deleteProjectDetails(Long projectId);

	ProjectReqDto getProjectDetails(Long projectId);

	Project updateProjectDetails(Project project);

}
