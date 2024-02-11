package com.skio.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teams")
@NoArgsConstructor
public class Team extends BaseEntity {
    @Column(name = "team_name", length = 30, unique = true)
    private String teamName;

    @Column(name = "members")
    private int noOfMembers;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    //modelling with a join table
    @OneToOne
    @JoinTable(
            name = "team_project",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", unique = true)
    )
    private Project project;


    public Team(String teamName, int noOfMembers) {
        super();
        this.teamName = teamName;
        this.noOfMembers = noOfMembers;
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
        return "Team [id=" + getId() + " ,teamName=" + teamName + ", noOfMembers=" + noOfMembers + "]";
    }


}

