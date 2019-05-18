package com.quan.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // creating available bean for other class
public class TopicsService {
	
	@Autowired
	private RepoService repoService;
	
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("JQuery", "Learninng  JQuery"),
			new Topic("React", "Learninng  React")
			));
	  
    public List<Topic> listTopics() {
    	    List<Topic> listTopic = new ArrayList<Topic>();
    	    repoService.findAll().forEach(listTopic::add);
			return listTopic;
		}

	public Topic getTopic(String id) {
		Topic topic = repoService.findById(id).orElse(null);
		return topic;
	}


	public void addTopic(@RequestBody Topic topic) {
		repoService.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getTitle().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	//version 1
	/*public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		for (Topic topic : topics) {
		    if(topic.getTitle().equals(id)) {
			topics.remove(topic);
			return;
		    }
		}
		
	} */

// version 2

	public void deleteTopic(String id) {
		topics.removeIf((t) -> t.getTitle().equals(id));
	}
	    
}
