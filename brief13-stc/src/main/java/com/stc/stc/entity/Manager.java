package com.stc.stc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Manager extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MANAGER")
	private Long id_manager;
	@Column(name="DOMAIN")
	private String domain;
	@Column(name="TYPE")
	private String type;
	@Column(name="STATUS")
	private String status;
	

}
