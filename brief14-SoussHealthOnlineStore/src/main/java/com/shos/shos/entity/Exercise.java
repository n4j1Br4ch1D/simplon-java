package com.shos.shos.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
	
	@Id
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
    @Column(name = "started_at", columnDefinition = "DATE")
    private LocalDate startedAt;
    
    @Column(name = "ended_at", columnDefinition = "DATE")
    private LocalDate endedAt;
	
	private boolean enabled;
	
	
    @OneToOne(mappedBy = "exercise")
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;
    

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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

    
}
