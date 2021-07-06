package com.jobApplicaton.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobApplicaton.model.User;




public class UserDetailsImp implements UserDetails {
	
//	@Autowired
//	private UserRoleDao userRoleDao;
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String email;
	private String password;
	private User user;
	
	private boolean active;
	
	private Collection<? extends GrantedAuthority>autho;
	
	
	
	
	public UserDetailsImp() {
		
	}
	
	public UserDetailsImp build(User user) {
//		List<GrantedAuthority>list = user.getUserRole().stream().filter(i->i.isActive()==true).
//				map(role -> new SimpleGrantedAuthority(role.getRole().getName().name())).collect(Collectors.toList());
		
		List<GrantedAuthority>li = Arrays.asList(new SimpleGrantedAuthority(user.getStatus().name()));
		
		return new UserDetailsImp(user.getId(), user.getEmail(), user.getPassword(),
				user,isAccountNonExpired(),  li);	
	}


	public UserDetailsImp(int id, String email, String password, User user, boolean active,
			Collection<? extends GrantedAuthority> autho) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.user = user;
		this.active = active;
		this.autho = autho;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}


	public boolean isActive() {
		return active;
	}

	

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autho;
	}


}
