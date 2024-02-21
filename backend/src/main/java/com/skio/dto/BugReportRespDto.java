package com.skio.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugReportRespDto {
	
	private Long id;
	private String title;
	private String description;
	private LocalDateTime lastmodified;
	private Long bug_id;
	public BugReportRespDto(Long id, String title, String description, Long bug_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.lastmodified = LocalDateTime.now();
		this.bug_id = bug_id;
	}
	
	
	
}
