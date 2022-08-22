package com.stc.stc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer id;

	private String name;
	@Column(name = "started_at")
	private Date startedAt;
	@Column(name = "ended_at")
	private Date endedAt;
	
	private Status status;
	
    @OneToOne(mappedBy = "exercise")
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    private Activity activity;

}
