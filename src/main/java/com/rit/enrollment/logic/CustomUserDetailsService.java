package com.rit.enrollment.logic;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rit.enrollment.repository.User;
import com.rit.enrollment.repository.UserRepository;
import com.rit.enrollment.repository.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

/*
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 User user = userRepository.findUserRoles(username);
	 if (user == null)
		 throw new UsernameNotFoundException("UserName not found");
	 return new CustomUserDetails(user, user.getRole());
}
*/
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepository.findUserRoles(username);
		 if (user == null)
			 throw new UsernameNotFoundException("UserName not found");
		 Set<GrantedAuthority> grantedAuthorities = new HashSet();
		 grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
		 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);//new CustomUserDetails(user, user.getRole());
	}	

}
