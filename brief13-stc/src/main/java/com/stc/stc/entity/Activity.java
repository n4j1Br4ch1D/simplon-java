package com.stc.stc.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.stc.stc.model.Exercises;
import com.stc.stc.model.Manager;
import com.stc.stc.model.Participant;
@Entity
@Table
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ACTIVITY")
    private Long id_activity;
	@Column(name="TITLE")
    private String title;
	@Column(name="DESCRIPTION")
    private String description;
	@Column(name="TYPE")
    private String type;
	@Column(name="STARTDATE")
    private Date startDate;
	@Column(name="ENDDATE")
    private Date endDate;
	@Column(name="STATUS")
    private String status;
    
    @ManyToMany(mappedBy = "activity",fetch = FetchType.EAGER)
    private Collection<Participant>particip; 
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Manager manager;
    
    @OneToOne(mappedBy = "activity",fetch = FetchType.EAGER)
    private Collection<Exercises>exercise;

}
