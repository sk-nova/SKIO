package com.skio.dto;

import java.util.List;

import com.skio.models.ProjectType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectReqDto {
	private Long id;
	private String title;
	private String desciption;
	private ProjectType type;
	private Long team_id;
	private List<BugRespDto> bugsFound;
}
