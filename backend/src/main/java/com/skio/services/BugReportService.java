package com.skio.services;

import java.util.List;

import com.skio.models.BugReport;

public interface BugReportService {

	List<BugReport> getAllBugReports();

	BugReport addBugReportDetails(BugReport newBugReport);

	String deleteBugReportDetails(Long bugReportId);

	BugReport getBugReportDetails(Long bugReportId);

	BugReport updateBugReportDetails(BugReport bugReport);

}
