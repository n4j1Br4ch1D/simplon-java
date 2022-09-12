package com.shos.shos.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Status {
   private String activity_status;   // Endeed, InProgress
   private String excercice_status;   // Endeed, InProgress
public String getActivity_status() {
	return activity_status;
}
public void setActivity_status(String activity_status) {
	this.activity_status = activity_status;
}
public String getExcercice_status() {
	return excercice_status;
}
public void setExcercice_status(String excercice_status) {
	this.excercice_status = excercice_status;
}
   
}
