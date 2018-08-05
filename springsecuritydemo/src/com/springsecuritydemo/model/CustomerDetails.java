package com.springsecuritydemo.model;

import java.io.Serializable;

public class CustomerDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String name;
	
	

	public CustomerDetails(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(final String name) {
		super();

		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
