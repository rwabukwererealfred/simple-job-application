package com.jobApplicaton.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobApplicaton.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	Optional<User>findByEmail(String username);
}

