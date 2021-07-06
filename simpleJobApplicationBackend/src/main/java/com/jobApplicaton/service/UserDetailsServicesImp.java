package com.jobApplicaton.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobApplicaton.dao.UserDao;
import com.jobApplicaton.model.User;

@Service
public class UserDetailsServicesImp implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username).orElseThrow(()->
		new UsernameNotFoundException("username not found with this username"+username));
		return new UserDetailsImp().build(user)	;
	}

}
