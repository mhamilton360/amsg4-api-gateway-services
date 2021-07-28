package com.coat.ams.api.users.ui.model;

import java.util.List;

import lombok.Data;

@Data
public class UserResponseModel {
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String username;
	private String token;
	
    private List<AllocationRecapResponseModel> recaps;
    
}
