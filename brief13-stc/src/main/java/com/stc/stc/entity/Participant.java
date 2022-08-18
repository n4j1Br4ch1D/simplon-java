package com.stc.stc.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participant {
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String domain;
	@Column(name="is_male")
	private boolean isMale;
    
    @ManyToMany(mappedBy = "participants", fetch = FetchType.EAGER)
	private Collection<Activity> activities;
}
