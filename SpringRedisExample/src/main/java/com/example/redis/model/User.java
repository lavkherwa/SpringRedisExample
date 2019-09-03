package com.example.redis.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5929708588206274262L;

	private String id;
	private String name;
	private String designation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
