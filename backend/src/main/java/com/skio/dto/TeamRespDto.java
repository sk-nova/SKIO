package com.skio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRespDto {
	//id | name | no_of_members
	
	private Long id;
	private String name;
	private int noOfMembers;
	
}
