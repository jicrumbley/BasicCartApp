package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="practice_user")
public class User {

	@Id
	@Column(name="user_name")
	String username;
	
	@Column(nullable=false, unique=true, name="user_id")
	int id;

	public User(String username, int id) {
		super();
		this.username = username;
		this.id = id;
	}
	
	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
