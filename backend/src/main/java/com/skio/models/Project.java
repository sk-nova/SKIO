package com.skio.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
public class Project extends BaseEntity{
	
	@Column(length=50)
	private String title;
	
	@Column(length=200)
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

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Bug> bugsFound;

	public Project(String name, String description, LocalDate assignedDate, LocalDate endDate, ProjectType type) {
		super();
		this.title = name;
		this.description = description;
		this.assignedDate = assignedDate;
		this.endDate = endDate;
		this.type = type;
	}
	
	//helper methods
	public void addBugs(Bug bug) {
		this.bugsFound.add(bug);
		bug.setProject(this);
	}
	
	public void removeBugs(Bug bug) {
		this.bugsFound.remove(bug);
		bug.setProject(null);
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
