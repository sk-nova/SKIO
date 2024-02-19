package com.skio.services;

import java.util.List;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skio.custom_exceptions.ResourceNotFoundException;
import com.skio.dao.BugReportDao;
import com.skio.models.BugReport;

@Service
@Transactional
public class BugReportServiceImpl implements BugReportService {
	@Autowired
	private BugReportDao bugReportDao;
//	@Autowired
//	private ModelMapper mapper;
	
	@Override
	public List<BugReport> getAllBugReports() {
		return bugReportDao.findAll();
	}
	
	@Override
	public BugReport addBugReportDetails(BugReport newBugReport) {
		return bugReportDao.save(newBugReport);
		//return detached entity to the BugReport
	}
	
	@Override
	public String deleteBugReportDetails(Long bugReportId) {
		// TODO Auto-generated method stub
		if(bugReportDao.existsById(bugReportId)) {
			bugReportDao.deleteById(bugReportId);
		}
		throw new ResourceNotFoundException("BugReport details cannot be deleted");
	}
	
	@Override
	public BugReport getBugReportDetails(Long bugReportId) {
		return bugReportDao.findById(bugReportId).orElseThrow(() -> new ResourceNotFoundException("Invalid BugReport Id!!"));
	}
	
	@Override
	public BugReport updateBugReportDetails(BugReport bugReport) {
		// TODO Auto-generated method stub
		return bugReportDao.save(bugReport);
	}
	
	
}
