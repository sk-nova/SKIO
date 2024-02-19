package com.skio.services;

import java.util.List;

import com.skio.models.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	Project addProjectDetails(Project newProject);

	String deleteProjectDetails(Long projectId);

	Project getProjectDetails(Long projectId);

	Project updateProjectDetails(Project project);

}
