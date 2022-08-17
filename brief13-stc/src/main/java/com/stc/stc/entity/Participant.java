package com.stc.stc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Participant extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PARTICIPANT")
	private Long id_participant;
	@Column(name="DOMAIN")
	private String domain;
	@Column(name="GENDER")
	private String gender;
	@Column(name="STATUS")
	private String status;

}
