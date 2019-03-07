package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="practice_password")
public class Password {
	
	@Id
	@Column(name="user_id")
	int id;
	
	@Column(name="password", nullable=false)
	String password;

	public Password(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public Password() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
