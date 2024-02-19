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
import com.skio.models.BugReport;
import com.skio.services.BugReportService;

@RestController
@RequestMapping("/bugReport-report")
@CrossOrigin(origins = "http://localhost:5173")
public class BugReportController {
	@Autowired(required = true)
	private BugReportService bugReportServ;
	
	public BugReportController() {
		System.out.println("in bugReport controller");
	}
	
	@GetMapping
	public List<BugReport> listAllBugReports(){
		return bugReportServ.getAllBugReports();
	}
	
	@PostMapping
	public BugReport addBugReportDetails(@RequestBody BugReport newBugReport) {
		return bugReportServ.addBugReportDetails(newBugReport);
	}
	
	@DeleteMapping("{/bugReportId}")
	public ResponseEntity<?> deleteBugReportDetails(@PathVariable Long bugReportId){
		System.out.println("in del bugReport id: " + bugReportId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(bugReportServ.deleteBugReportDetails(bugReportId)));
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/bugReportId")
	public BugReport getBugReportDetails(@PathVariable Long bugReportId) {
		return bugReportServ.getBugReportDetails(bugReportId);
	}
	
	@PutMapping
	public BugReport updateBugReportDetails(@RequestBody BugReport bugReport) {
		return bugReportServ.updateBugReportDetails(bugReport);
	}

}
