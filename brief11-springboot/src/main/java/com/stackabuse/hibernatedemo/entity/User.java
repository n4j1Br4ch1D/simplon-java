package com.stackabuse.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
  
    @Id  
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name= "role")
	private String role;

	@Column(name= "approved")
	private boolean approved;

	@Column(name= "email")
	private String email;

  @Column(name= "password")
	private String password;
	
	
  @Column(name= "tasks_number")
	private Integer tasks;



	//Dates;
  


	public User() {
		super();
	}
	
	
	public User(String fullName, String role, boolean approved, String email, String password, Integer tasks) {
		super();
		this.fullName = fullName;
		this.role = role;
		this.approved = approved;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}


	public User(Integer id, String fullName, String role, boolean approved, String email, String password,
			Integer tasks) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.role = role;
		this.approved = approved;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
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


	public Integer getTasks() {
		return tasks;
	}


	public void setTasks(Integer tasks) {
		this.tasks = tasks;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", role=" + role + ", approved=" + approved + ", email="
				+ email + ", password=" + password + ", tasks=" + tasks + "]";
	}


}
