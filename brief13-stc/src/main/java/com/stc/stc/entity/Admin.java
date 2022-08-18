package com.stc.stc.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Admin extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admin;
	
	
	@Embedded
	private Status status;


}
