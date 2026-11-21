package com.tripsync.auth.dao;

public record AuthResponse(
		String accessToken,
		String tokenType,
		long expiresIn
		) 
{

}
