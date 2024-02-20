package com.skio.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.BugDao;
import com.skio.models.Bug;


@Service
@Transactional
public class BugServiceImpl implements BugService {

	@Autowired
	private BugDao bugDao;
//	@Autowired
//	private ModelMapper mapper;
	
	@Override
	public List<Bug> getAllBugs() {
		return bugDao.findAll();
	}
	
	@Override
	public Bug addBugDetails(Bug newBug) {
		return bugDao.save(newBug);
		//return detached entity to the Bug
	}
	
	@Override
	public String deleteBugDetails(Long bugId) {
		// TODO Auto-generated method stub
		if(bugDao.existsById(bugId)) {
			bugDao.deleteById(bugId);
			return "Bug deleted successfully";
		}
		throw new ResourceNotFoundException("Bug details cannot be deleted");
	}
	
	@Override
	public Bug getBugDetails(Long bugId) {
		return bugDao.findById(bugId).orElseThrow(() -> new ResourceNotFoundException("Invalid Bug Id!!"));
	}
	
	@Override
	public Bug updateBugDetails(Bug bug) {
		// TODO Auto-generated method stub
		return bugDao.save(bug);
	}

}
