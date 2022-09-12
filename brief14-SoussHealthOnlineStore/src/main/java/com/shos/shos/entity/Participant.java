package com.shos.shos.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participant extends User{
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String domain;
    
//    @ManyToMany(mappedBy = "participants", fetch = FetchType.EAGER)
//	private Collection<Activity> activities;
    
    @OneToMany(mappedBy = "participant")
	private Collection<ParticipantActivity> participantActivities;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Collection<ParticipantActivity> getParticipantActivities() {
		return participantActivities;
	}

	public void setParticipantActivities(Collection<ParticipantActivity> participantActivities) {
		this.participantActivities = participantActivities;
	}
    
}
