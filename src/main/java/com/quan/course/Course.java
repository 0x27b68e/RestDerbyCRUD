package com.quan.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.quan.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String title;
	private String name;
	
	@ManyToOne //jps Annotation
	private Topic topic; //ManyToOne, One Topic have many courses

	public Course() {
	}
	
	public Course(String title, String name, String topicId) {
		super();
		this.title = title;
		this.name = name;
		this.topic = new Topic(topicId, "");
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
