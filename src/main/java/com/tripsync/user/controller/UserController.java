package com.tripsync.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripsync.user.dto.RegisterRequest;
import com.tripsync.user.dto.UserResponse;
import com.tripsync.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController
{
	private final UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest)
	{
		UserResponse response = userService.register(registerRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}

}
