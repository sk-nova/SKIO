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
import com.skio.models.Bug;
import com.skio.services.BugService;

@RestController
@RequestMapping("/bugs")
@CrossOrigin(origins = "http://localhost:5173")
public class BugController {
	
	@Autowired(required = true)
	private BugService bugServ;
	
	public BugController() {
		System.out.println("in bug controller");
	}
	
	@GetMapping
	public List<Bug> listAllBugs(){
		return bugServ.getAllBugs();
	}
	
	@PostMapping
	public Bug addBugDetails(@RequestBody Bug newBug) {
		return bugServ.addBugDetails(newBug);
	}
	
	@DeleteMapping("/{bugId}")
	public ResponseEntity<?> deleteBugDetails(@PathVariable Long bugId){
		System.out.println("in del bug id: " + bugId);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(bugServ.deleteBugDetails(bugId)));
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{bugId}")
	public Bug getBugDetails(@PathVariable Long bugId) {
		return bugServ.getBugDetails(bugId);
	}
	
	@PutMapping
	public Bug updateBugDetails(@RequestBody Bug bug) {
		return bugServ.updateBugDetails(bug);
	}
	
}
