package com.stc.stc.dto;

import java.util.Collection;

import javax.validation.Valid;

import com.stc.stc.entity.ParticipantActivity;

@Valid
public class ParticipantDto extends UserDto{
	private Long id;
	private String domain;
	private Collection<ParticipantActivity> participantActivities;
	//Status

	public ParticipantDto() {
		super();
	}
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
