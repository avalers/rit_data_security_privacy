package com.rit.enrollment.repository;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role;
	private com.rit.enrollment.repository.User user;
	
	public CustomUserDetails(com.rit.enrollment.repository.User user, String role){
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(role));
		this.user = user;
	}

	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(role);
	}*/

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
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}
