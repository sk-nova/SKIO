package com.skio.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bugs")
@Getter
@Setter
@NoArgsConstructor
public class Bug extends BaseEntity{
	@Column(length = 50)
	private String name;
	
	private int priority;
	
	@Enumerated(EnumType.STRING)
	private BugStatus status;
	@Column(length = 200)
	private String Description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime reportedDateAndTime;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
    @JoinColumn(name = "reporter_id")
	private User reportedBy;
	
	@ManyToOne
    @JoinColumn(name = "assignee_id")
	private User assignedTo;
	
	@OneToOne(mappedBy = "bug", cascade = CascadeType.REMOVE)
    private BugReport bugReport;
	
	public Bug(String name, int priority, BugStatus status, String description) {
		super();
		this.name = name;
		this.priority = priority;
		this.status = status;
		Description = description;
		this.reportedDateAndTime = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Bug [id="+ getId()+ ", name=" + name + ", priority=" + priority + ", status=" + status + ", Description=" + Description 
				+ ", reportedDateAndTime="+ reportedDateAndTime
				+ "]";
	}
	
	
	
}
