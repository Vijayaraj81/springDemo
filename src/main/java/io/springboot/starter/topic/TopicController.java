//this package should be in CONTROLLER package
package io.springboot.starter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topics> topics() {
		return topicService.getTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topics> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public List<Topics> addTopic(@RequestBody Topics topics) {
		return topicService.addTopic(topics);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public List<Topics> updateTopic(@RequestBody Topics topics, @PathVariable String id) {
		return topicService.updateTopic(id, topics);
	}
	
	//Delete method
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public List<Topics> deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id);
	}

}
