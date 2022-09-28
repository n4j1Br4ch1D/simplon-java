package com.shos.shos.dto;


import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String userName;

	@NotBlank
	private String password;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}