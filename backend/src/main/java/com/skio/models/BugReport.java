package com.skio.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bug_report")
@Getter
@Setter
@NoArgsConstructor
public class BugReport extends BaseEntity{
	
	@Column(length = 50)
	private String title;
	
	@Column(length = 200)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime lastModified;
	
	@OneToOne
    @JoinColumn(name = "bug_id")
    private Bug bug;
	
	public BugReport(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.lastModified = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "BugReport [id="+ getId() + ", title=" + title + ", description=" + description + ", lastModified=" + lastModified + "]";
	}
	
	
}
