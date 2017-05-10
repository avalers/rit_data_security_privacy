package com.rit.enrollment.logic;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rit.enrollment.repository.User;
import com.rit.enrollment.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	


	@Override
	@Transactional
	public User getUser(Integer id) {
		/*User user = new User();
		user.setUsername("avalers");
		user.setPassword("pepe");
		user.setRole("STUDENT");*/
		return null;
	}


	
}
