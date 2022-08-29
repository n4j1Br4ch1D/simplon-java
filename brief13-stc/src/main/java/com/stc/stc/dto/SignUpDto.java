package com.stc.stc.dto;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Valid
public class SignUpDto {
    @NotNull
    @Column(length = 20)//
    private String fullName;
    @NotEmpty
    @Size(min = 2, message = "Fulltime should have at least 2 characters")
    private String userName;
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 4, max = 8 , message = "Must have characters & number at least 5")//
    private String password;

	public SignUpDto() {
		super();
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
