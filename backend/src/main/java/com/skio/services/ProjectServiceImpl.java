package com.skio.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.ProjectDao;
import com.skio.models.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectDao projectDao;
//	@Autowired
//	private ModelMapper mapper;
	
	@Override
	public List<Project> getAllProjects() {
		return projectDao.findAll();
	}
	
	@Override
	public Project addProjectDetails(Project newProject) {
		return projectDao.save(newProject);
		//return detached entity to the Project
	}
	
	@Override
	public String deleteProjectDetails(Long projectId) {
		// TODO Auto-generated method stub
		if(projectDao.existsById(projectId)) {
			projectDao.deleteById(projectId);
		}
		throw new ResourceNotFoundException("Project details cannot be deleted");
	}
	
	@Override
	public Project getProjectDetails(Long projectId) {
		return projectDao.findById(projectId).orElseThrow(() -> new ResourceNotFoundException("Invalid Project Id!!"));
	}
	
	@Override
	public Project updateProjectDetails(Project project) {
		// TODO Auto-generated method stub
		return projectDao.save(project);
	}
	

}
