package com.skio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skio.models.User;

public interface UserDao extends JpaRepository<User, Long> {

}
