package io.javabrains.springboot.Topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController { 
	
	@Autowired
	private TopicService topicservice ;  
	
     
	@RequestMapping("/topics")
	 public List<Topic> getAllTopics() {   
		 return topicservice.getalltopics();
	
	 } 
	 
	 @RequestMapping("/topics/{id}")
	 public Topic getTopic(@PathVariable String id){ 
		 return topicservice.getTopic(id);
	 } 
	  
	 @RequestMapping(method = RequestMethod.POST , value = "/topics")
	 public void addTopic(@RequestBody Topic tp) {  
		 topicservice.addTopic(tp);
	 } 
	 
	 @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
	 public void UpdateTopic(@RequestBody Topic tp ,@PathVariable String id ) {  
		 topicservice.updateTopic(tp,id);
	 } 
	 
	 @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
	 public void DeleteTopic(@PathVariable String id ) {  
		 topicservice.DeleteTopic(id);
	 } 
	 
	 
	 
	 
	 
	 
	 
}
