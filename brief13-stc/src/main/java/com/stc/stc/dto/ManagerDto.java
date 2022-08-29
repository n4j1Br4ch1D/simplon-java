package com.stc.stc.dto;

public class ManagerDto extends UserDto{
	private Long id;
	private String domain;
	private String type; // trainer, speaker
	public ManagerDto() {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
