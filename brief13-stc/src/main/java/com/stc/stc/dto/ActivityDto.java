package com.stc.stc.dto;

import java.time.LocalDate;
import java.util.Collection;

import com.stc.stc.entity.Exercise;
import com.stc.stc.entity.Manager;
import com.stc.stc.entity.ParticipantActivity;

public class ActivityDto {
	private Long id;
    private String name;
    private String description;
    private String type; //training, talking, event
    private boolean enabled;

    private LocalDate startedAt;
    
    private LocalDate endedAt;

    private Exercise exercise;

    private Manager manager;

	private Collection<ParticipantActivity> participantActivities;

	public ActivityDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(LocalDate startedAt) {
		this.startedAt = startedAt;
	}

	public LocalDate getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(LocalDate endedAt) {
		this.endedAt = endedAt;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Collection<ParticipantActivity> getParticipantActivities() {
		return participantActivities;
	}

	public void setParticipantActivities(Collection<ParticipantActivity> participantActivities) {
		this.participantActivities = participantActivities;
	}
	
	
}
