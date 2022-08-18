package com.stc.stc.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Status {
   private String active;   
   private String disabled;
   private String in_progress;
   private String ended;
}
