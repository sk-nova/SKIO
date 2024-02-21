package com.skio.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{
	@Column(length=20)
	private String userName;
	
	@Column(length=20)
	private String firstName;
	
	@Column(length=20)
	private String lastName;
	
	//@Email
	@Column(length = 100, unique = true)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length=13)
	private String contact;
	
	@Column(length=20)
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	@OneToMany(mappedBy = "reportedBy", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bug> reportedBugs;
	
	@OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bug> assignedBugs;
	
	public User(String userName, String firstName, String lastName, @Email String email, String password,
			String contact, String role) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.role = role;
//		this.team.setNoOfMembers(this.team.getNoOfMembers()+1);
	}
	
	//helper methods - reported bugs and assigned bugs
	public void addReportedBugs(Bug bug){
		this.reportedBugs.add(bug);
		bug.setReportedBy(this);
	}
	
	public void addAssignedBugs(Bug bug) {
		this.assignedBugs.add(bug);
		bug.setAssignedTo(this);
	}
	
	public void removeReportedBugs(Bug bug){
		this.reportedBugs.remove(bug);
		bug.setReportedBy(null);
	}
	
	public void removeAssignedBugs(Bug bug) {
		this.assignedBugs.remove(bug);
		bug.setAssignedTo(null);
	}

	@Override
	public String toString() {
		return "User [id="+ getId() +" ,userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + ", role=" + role + "]";
	}
	
}
