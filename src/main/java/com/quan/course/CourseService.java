package com.quan.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class CourseService {
	
	@Autowired
	CourseRepoService courseRepoService;
	  
    public List<Course> listCourses(String id) {//todo
    	    List<Course> listCourse = new ArrayList<Course>();
    	    courseRepoService.findAll().forEach(listCourse::add);
			return listCourse;
		}

	public Course getCourse(String id) {
		Course course = courseRepoService.findById(id).orElse(null);
		return course;
	}


	public void addCourse(@RequestBody Course course) {
		courseRepoService.save(course);
	}

	public void updateCourse(String id, Course course) {
		boolean haveCourse = courseRepoService.findById(id).isPresent();
		if(haveCourse)
			courseRepoService.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepoService.deleteById(id);
	}
	    
}
