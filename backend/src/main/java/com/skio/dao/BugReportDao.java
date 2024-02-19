package com.skio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skio.models.BugReport;

public interface BugReportDao extends JpaRepository<BugReport, Long> {

}
