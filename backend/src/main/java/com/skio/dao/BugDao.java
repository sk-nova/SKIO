package com.skio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skio.models.Bug;

public interface BugDao extends JpaRepository<Bug, Long> {

}
