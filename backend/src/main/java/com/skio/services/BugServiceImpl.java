package com.skio.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.BugDao;
import com.skio.dao.ProjectDao;
import com.skio.dao.UserDao;
import com.skio.dto.BugRespDto;
import com.skio.dto.UserRespDto;
import com.skio.models.Bug;
import com.skio.models.Project;
import com.skio.models.User;

@Service
@Transactional
public class BugServiceImpl implements BugService {

	@Autowired
	private BugDao bugDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProjectDao projectDao;

	@Override
	public List<BugRespDto> getAllBugs() {
		List<BugRespDto> response = bugDao.findAll().stream().map(this::mapBugToBugRespDto)
				.collect(Collectors.toList());
		return response;
	}
//	private Long projectId;
//	private Long reporterId;
//	private Long assigneeId;

	private BugRespDto mapBugToBugRespDto(Bug bug) {
		BugRespDto bugResp = mapper.map(bug, BugRespDto.class);

		// Set the team_id from the User's Team entity
		if (bug.getAssignedTo() != null || bug.getProject() != null || bug.getReportedBy() != null) {
			bugResp.setAssigneeId(bug.getAssignedTo().getId());
			bugResp.setProjectId(bug.getProject().getId());
			bugResp.setReporterId(bug.getReportedBy().getId());
		}

		return bugResp;
	}

	@Override
	public BugRespDto addBugDetails(BugRespDto newBug) {
		Bug bug = mapper.map(newBug, Bug.class);
		User reportedby = userDao.findById(newBug.getReporterId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of reporter's!!!"));
		bug.setReportedBy(reportedby);
		User assignedTo = userDao.findById(newBug.getAssigneeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of assignee's!!!"));
		bug.setAssignedTo(assignedTo);
		Project project = projectDao.findById(newBug.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of project!!!"));
		bug.setProject(project);

		return mapper.map(bugDao.save(bug), BugRespDto.class);

		// return detached entity to the Bug
	}

	@Override
	public String deleteBugDetails(Long bugId) {
		// TODO Auto-generated method stub
		if (bugDao.existsById(bugId)) {
			bugDao.deleteById(bugId);
			return "Bug deleted successfully";
		}
		throw new ResourceNotFoundException("Bug details cannot be deleted");
	}

	@Override
	public BugRespDto getBugDetails(Long bugId) {
		Bug bug = bugDao.findById(bugId).orElseThrow(() -> new ResourceNotFoundException("Invalid Bug Id!!!"));
		return this.mapBugToBugRespDto(bug);
	}

	@Override
	public BugRespDto updateBugDetails(BugRespDto bugDto) {
		Bug bug = mapper.map(bugDto, Bug.class);
		User reportedby = userDao.findById(bugDto.getReporterId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of reporter's!!!"));
		bug.setReportedBy(reportedby);
		User assignedTo = userDao.findById(bugDto.getAssigneeId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of assignee's!!!"));
		bug.setAssignedTo(assignedTo);
		Project project = projectDao.findById(bugDto.getProjectId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid id of project!!!"));
		bug.setProject(project);

		return mapper.map(bugDao.save(bug), BugRespDto.class);
	}

}
