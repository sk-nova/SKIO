package com.skio.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BugRespDto {
	
	private Long id;
	private String name;
	private int priority;
	private LocalDateTime reportedDateAndTime;
	private Long projectId;
	private Long reporterId;
	private Long assigneeId;
	private String description;
	
	
	public BugRespDto(Long id, String name, int priority,  Long projectId,
			Long reporterId, Long assigneeId, String description) {
		super();
		this.id = id;
		this.name = name;
		this.priority = priority;
		this.reportedDateAndTime = LocalDateTime.now();
		this.projectId = projectId;
		this.reporterId = reporterId;
		this.assigneeId = assigneeId;
		this.description = description;
	}
	
	
}
