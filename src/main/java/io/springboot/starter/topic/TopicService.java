//this class should be in SERVICE package, it interacts with topicrepository.class to access data, and 
//sends the data to controller to display as json or in JSP 
package io.springboot.starter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topics> getTopics() {
		//return topics; 
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topics> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public List<Topics> addTopic(Topics addTopic) {
		//topics.add(addTopic);
		//return topics;
		topicRepository.save(addTopic);
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public List<Topics> updateTopic(String id, Topics topics2) {
		topicRepository.save(topics2);
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public List<Topics> deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		//return topics;
		topicRepository.deleteById(id);
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		
	}

}
