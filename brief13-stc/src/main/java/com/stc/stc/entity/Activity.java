package com.stc.stc.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;


@Entity
@Table(name = "activities")
public class Activity {

	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String description;
    private String type; //training, talking, event
    private boolean enabled;

    @Column(name = "started_at", columnDefinition = "DATE")
    private LocalDate startedAt;
    
    @Column(name = "ended_at", columnDefinition = "DATE")
    private LocalDate endedAt;
	
    
    @OneToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_id", nullable = true, columnDefinition = "integer")
    private Exercise exercise;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="manager_id", nullable = true, columnDefinition = "integer")
    private Manager manager;
 

//	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinTable(name = "activities_participants", joinColumns = { @JoinColumn(name = "activity_id") }, 
//	inverseJoinColumns = { @JoinColumn(name = "participant_id") })
//    private Collection<Participant> participants;
	
	
    @OneToMany(mappedBy = "activity")	
	private Collection<ParticipantActivity> participantActivities;



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





}
