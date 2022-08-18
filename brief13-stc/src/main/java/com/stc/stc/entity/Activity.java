package com.stc.stc.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String type;
    
    private Date startedAt;
    private Date endedAt;
	
	
	@Embedded
	private Status status;
    
    @ManyToMany(mappedBy = "activity",fetch = FetchType.EAGER)
    private Collection<Participant>particip; 
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Manager manager;
    
    @OneToOne(mappedBy = "activity",fetch = FetchType.EAGER)
    private Collection<Excercie>excercies;

}
