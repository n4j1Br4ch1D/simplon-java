package com.shos.shos.entity;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Status {
   private String activity_status;   // Endeed, InProgress
   private String excercice_status;   // Endeed, InProgress
}
