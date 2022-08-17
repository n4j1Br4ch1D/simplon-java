package com.stc.stc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Excercie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_EXERCISES")
	private Long id_Exercises;
	@Column(name="STARTDATE")
	private Date startDate;
	@Column(name="ENDDATE")
	private Date endDate;
	@Column(name="STATUS")
	private String status;

}
