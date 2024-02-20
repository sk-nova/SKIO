package com.skio.dto;

import java.time.LocalDate;
import java.util.List;

import com.skio.models.ProjectType;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRespDto {
	private Long id;
	private String title;
	private String desciption;
	private ProjectType type;
	private LocalDate assignedDate;
	private LocalDate endDate;
	private Long teamId;
	
}
