package com.stc.stc.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.stc.stc.entity.Activity;

public class ExerciseDto  {
	@NotNull
	private Long id;
	@NotNull
	private String name;
	@NotNull
    private LocalDate startedAt;
	@NotNull
    private LocalDate endedAt;
	@NotNull
	private boolean enabled;
	@NotNull
    private Activity activity;

	public ExerciseDto() {
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
