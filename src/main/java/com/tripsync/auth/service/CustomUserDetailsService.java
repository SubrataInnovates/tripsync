package com.tripsync.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tripsync.user.entity.AccountStatus;
import com.tripsync.user.entity.User;
import com.tripsync.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService
{

	private final UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
	
	return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
			.password(user.getPasswordHash()).roles(user.getRole().name())
			.disabled(user.getStatus()!=AccountStatus.ACTIVE )
			.build();
	}

	
}
