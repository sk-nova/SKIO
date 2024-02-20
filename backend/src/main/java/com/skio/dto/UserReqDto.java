package com.skio.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {
	//String userName, String firstName, String lastName, @Email String email, String password,
	//String contact, String role
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String contact;
	private String role;
	private Long teamId;
}
