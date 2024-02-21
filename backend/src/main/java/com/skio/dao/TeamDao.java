package com.skio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skio.models.Team;

public interface TeamDao extends JpaRepository<Team, Long> {

}
