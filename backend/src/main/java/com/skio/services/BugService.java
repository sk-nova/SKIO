package com.skio.services;

import java.util.List;

import com.skio.models.Bug;

public interface BugService {

	List<Bug> getAllBugs();

	Bug addBugDetails(Bug newBug);

	String deleteBugDetails(Long bugId);

	Bug getBugDetails(Long bugId);

	Bug updateBugDetails(Bug bug);

}
