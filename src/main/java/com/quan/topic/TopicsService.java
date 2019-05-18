package com.quan.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TopicsService {
	
	@Autowired
	private RepoService repoService;
	  
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
		boolean haveTopic = repoService.findById(id).isPresent();
		if(haveTopic)
		repoService.save(topic);
		
	}

	public void deleteTopic(String id) {
		repoService.deleteById(id);
	}
	    
}
