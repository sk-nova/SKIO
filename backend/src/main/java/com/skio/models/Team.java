package com.skio.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@NoArgsConstructor
public class Team extends BaseEntity{
	@Column(length = 30,unique = true)
	private String name;
	
	private int noOfMembers;
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users = new ArrayList<>();
	
	//modelling with a join table
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private Project project;
	
	
	public Team(String teamName, int noOfMembers) {
		super();
		this.name = teamName;
		this.noOfMembers = noOfMembers;
	}
	
	public String getTeamName() {
		return name;
	}

	public void setTeamName(String teamName) {
		this.name = teamName;
	}

	public int getNoOfMembers() {
		return noOfMembers;
	}

	public void setNoOfMembers(int noOfMembers) {
		this.noOfMembers = noOfMembers;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	//helper methods
	public void addUser(User u) {
		this.users.add(u);
	    u.setTeam(this);
	}
	
	public void removeUser(User u) {
		this.users.remove(u);
		u.setTeam(null);
	}

	@Override
	public String toString() {
		return "Team [id="+ getId() + " ,teamName=" + name + ", noOfMembers=" + noOfMembers + "]";
	}

	
	
	

}
