package com.jobApplicaton.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobApplicaton.config.JwtUtils;
import com.jobApplicaton.request.LoginForm;
import com.jobApplicaton.response.JwtResponse;
import com.jobApplicaton.service.UserDetailsImp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/authentication/")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authonticationManager;
	

	@Autowired
	private JwtUtils jwtutils;
	
	@PostMapping("signin")
	public ResponseEntity<?> SignIn(@Valid @RequestBody LoginForm login) {
		System.out.print("username: "+login.getUsername()+" password: "+login.getPassword());
		Authentication auth = authonticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwt = jwtutils.generateJwtToken(auth);
		UserDetailsImp us = (UserDetailsImp) auth.getPrincipal();
		 List<String> role = us.getAuthorities().stream().map(item ->
		 item.getAuthority()).collect(Collectors.toList());
		System.out.print("out put: " + us.getUsername()+ " role "+ role);
		return ResponseEntity.ok(new JwtResponse(us.getId(), us.getUsername(), us.getPassword(), us.isActive(),us.getUser(), role, jwt));
	}
}
