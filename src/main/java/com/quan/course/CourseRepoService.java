package com.quan.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepoService extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicTitle(String title);

}
