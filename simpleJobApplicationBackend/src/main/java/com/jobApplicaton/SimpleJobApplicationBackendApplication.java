package com.jobApplicaton;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jobApplicaton.model.User;
import com.jobApplicaton.model.User.Status;
import com.jobApplicaton.service.ApplicationService;

@SpringBootApplication
public class SimpleJobApplicationBackendApplication implements CommandLineRunner {
	
	@Autowired
	private ApplicationService service;
	
	@Autowired
	private PasswordEncoder encoder;
	

	public static void main(String[] args) {
		
		SpringApplication.run(SimpleJobApplicationBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Optional<User>email = service.email("ralfred18404@gmail.com");
		if(!email.isPresent()) {
			User user = new User();
			user.setFirstName("Rwabukwerere");
			user.setLastName("Alfred");
			user.setStatus(Status.HR);
			user.setEmail("ralfred18404@gmail.com");
			user.setActive(true);
			user.setPassword(encoder.encode("fred18404"));
			service.createAccount(user);
			
		}
		
	}

}
