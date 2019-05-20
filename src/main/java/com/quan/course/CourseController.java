package com.quan.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quan.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService coursesService;
	
	//localhost:8080/topics/Java/courses
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		
		return coursesService.listCourses(id);
	}
	
	//version 2, http://localhost:8080/topics/JQuery
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable("foo") String id) {
		return coursesService.getCourse(id);
	}
	
	/* data, path: http://localhost:8080/addTopic
	 *  {
		 "title": "Python",
		 "name": "Learnning Python"
		} */
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, ""));
		coursesService.addCourse(course);
	}
	
	/*
	 * localhost:8080/updateTopic/JQuery 
	 * { "title": "JQuery", 
	 * "name": "Learnning JQuery Update" }
	 */
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,""));
		coursesService.updateCourse(id, course);
	}
	
	//localhost:8080/deleteTopic/JQuery
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		coursesService.deleteCourse(id);
	}
	
	
	
}
