package com.skio.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity {
    @Column(length = 20)
    private String title;

    @Column(length = 20)
    private String description;

    @Column(name = "assigned_date")
    private LocalDate assignedDate;

    @Column(name = "end_date")
    private LocalDate endDate;

//    @Enumerated(EnumType.STRING) // varchar
//    @Column(length = 20)
//    private ProjectType type;

    @OneToOne(mappedBy = "project")
    private Team team;

    public String getTitle() {
        return title;
    }


    public Project(String name, String description, LocalDate assignedDate, LocalDate endDate) {
        super();
        this.title = name;
        this.description = description;
        this.assignedDate = assignedDate;
        this.endDate = endDate;
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
        return "Project [id= " + getId() + " ,name=" + title + ", description=" + description + ", assignedDate=" + assignedDate
                + ", endDate=" + endDate + "]";
    }


}