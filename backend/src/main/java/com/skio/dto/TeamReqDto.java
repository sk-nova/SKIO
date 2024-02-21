package com.skio.dto;

import java.util.List;

import com.skio.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamReqDto {
	//id | name | no_of_members
	
	private Long id;
	private String name;
	private int noOfMembers;
	private List<UserRespDto> users; 
	 
	
}
