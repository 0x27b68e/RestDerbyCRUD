package com.quan.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	
	@Id
	private String title;
	private String name;
	
	public Topic() {
	}
	
	public Topic(String title, String name) {
		super();
		this.title = title;
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
