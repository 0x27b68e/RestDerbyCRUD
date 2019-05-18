package com.quan.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	
	@Autowired
	private TopicsService topicsService;
	
	@RequestMapping(value = "/")
	public String home() {
		return "Enter /topics, /getTopics, /topics/{foo}, /addTopic";
	}
	
	//http://localhost:8080/topics
	@RequestMapping("/getTopics")
	public List<Topic> getlistTopic() {
		return topicsService.listTopics();
	}
	
	//http://localhost:8080/topics?title=JQuery
	@RequestMapping("/topics")
	public Topic getTopic(@RequestParam("title") String title) {
		return topicsService.getTopic(title);
	}
	
	//http://localhost:8080/topics/JQuery, version 1
	/*@RequestMapping("/topics/{title}")
	public Topic getTopic2(@PathVariable String title) {
		return topicsService.getTopic(title);
	}*/
	
	//version 2, http://localhost:8080/topics/JQuery
	@RequestMapping("/topics/{foo}")
	public Topic getTopic2(@PathVariable("foo") String title) {
		return topicsService.getTopic(title);
	}
	
	/* data, path: http://localhost:8080/addTopic
	 *  {
		 "title": "Python",
		 "name": "Learnning Python"
		} */
	
	@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) { // tell springboot that it need body for this path
		topicsService.addTopic(topic);
	}
	
	/*
	 * localhost:8080/updateTopic/JQuery 
	 * { "title": "JQuery", 
	 * "name": "Learnning JQuery Update" }
	 */
	@RequestMapping(value = "/updateTopic/{id}", method = RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		
		topicsService.updateTopic(id, topic);
		
	}
	
	//localhost:8080/deleteTopic/JQuery
	@RequestMapping(value = "/deleteTopic/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		topicsService.deleteTopic(id);
	}
	
	
	
}
