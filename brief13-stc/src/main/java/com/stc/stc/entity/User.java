package com.stc.stc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
  
    @Id  
	@Column(name = "id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_users;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
	private String lastName;
    @Column(name="TEL")
	private int  tel;
    @Column(name="EMAIL")
	private String email;
    @Column(name="ROLE")
	private String role;
	
	
 




}
