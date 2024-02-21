package com.skio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skio.models.Project;

public interface ProjectDao extends JpaRepository<Project, Long> {

}
