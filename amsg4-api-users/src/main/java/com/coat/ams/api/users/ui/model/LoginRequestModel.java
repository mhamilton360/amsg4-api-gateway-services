package com.coat.ams.api.users.ui.model;

import lombok.Data;

@Data
public class LoginRequestModel {
	private String username;
	private String email;
	private String id;
	private String password;
	private String firstName;
	private String lastName;
	private String token;

}
