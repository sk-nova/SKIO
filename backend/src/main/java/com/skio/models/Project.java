package com.skio.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project extends BaseEntity{
	@Column(length=20)
	private String title;
	@Column(length=20)
	private String description;
	@Column(name="start_date")
	private LocalDate assignedDate;
	@Column(name="end_date")
	private LocalDate endDate;
	@Enumerated(EnumType.STRING) // varchar
	@Column(length = 20)
	private ProjectType type;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team;
	
	public String getTitle() {
		return title;
	}
	
	public Project() {
		
	}
	public Project(String name, String description, LocalDate assignedDate, LocalDate endDate, ProjectType type) {
		super();
		this.title = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.endDate = endDate;
		this.type = type;
	}
	
	public void setTitle(String name) {
		this.title = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(LocalDate assignedDate) {
		this.assignedDate = assignedDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public ProjectType getType() {
		return type;
	}
	public void setType(ProjectType type) {
		this.type = type;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Project))
			return false;
		Project other = (Project) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Project [id= "+ getId() + " ,name=" + title + ", description=" + description + ", assignedDate=" + assignedDate
				+ ", endDate=" + endDate + ", type=" + type + "]";
	}
	
	
	
	
	
}
