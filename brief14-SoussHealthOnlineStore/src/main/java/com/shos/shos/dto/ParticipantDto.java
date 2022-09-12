package com.shos.shos.dto;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.shos.shos.entity.ParticipantActivity;

@Valid
public class ParticipantDto extends UserDto{
	@NotNull
	private Long id;
	@NotNull
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
