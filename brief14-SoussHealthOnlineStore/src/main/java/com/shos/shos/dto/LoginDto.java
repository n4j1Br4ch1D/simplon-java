package com.shos.shos.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class LoginDto {
	@NotEmpty
	@Column(unique=true)
    private String usernameOrEmail;
	@NotEmpty
	@Column(unique=true)
    private String password;
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	public LoginDto() {
		super();
	}
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
