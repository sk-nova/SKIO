package com.skio.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team extends BaseEntity{
	@Column(length = 30,unique = true)
	private String name;
	
	private int noOfMembers;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<>();
	
	//modelling with a join table
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Project> projects;
	
	
	public Team(String teamName, int noOfMembers) {
		super();
		this.name = teamName;
		this.noOfMembers = noOfMembers;
	}
	
	//helper methods
	public void addUser(User u) {
		this.users.add(u);
		u.setTeam(this);
		this.noOfMembers = users.size();
	}
	
	public void removeUser(User u) {
		this.users.remove(u);
		u.setTeam(null);
		this.noOfMembers = users.size();
	}
	
	public void addProject(Project project) {
		this.projects.add(project);
		project.setTeam(this);
	}
	
	public void removeProject(Project project) {
		this.projects.remove(project);
		project.setTeam(null);
	}

	@Override
	public String toString() {
		return "Team [id="+ getId() + " ,teamName=" + name + ", noOfMembers=" + noOfMembers + "]";
	}

	
	
	

}
