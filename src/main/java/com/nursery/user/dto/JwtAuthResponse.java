package com.nursery.user.dto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
	private UserDTO user;
}