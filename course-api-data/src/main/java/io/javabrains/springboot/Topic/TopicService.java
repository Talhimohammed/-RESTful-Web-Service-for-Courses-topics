package io.javabrains.springboot.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService { 
	
	
	@Autowired
	private TopicRepository topicRepository ;  
	
	 
	private List<Topic> Topics = new ArrayList<>( Arrays.asList( 
			   new Topic("Spring","Spring Framework","Spring Framwoek description"),		 
			   new Topic("Java","Core java","Core java description"),
			   new Topic("JavaScript"," Javascript ramework","Javascript description")
					 ) ) ;  
	
	public List<Topic> getalltopics(){ 
		 List<Topic> Topics = new ArrayList<>();
		 topicRepository.findAll().forEach(Topics :: add); 
		 return Topics ; 
	} 
	
	public Topic getTopic(String id){ 
	//	return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() ;  
		
		return (topicRepository.findById(id)).get();
	}

	public void addTopic(Topic tp) {
		 topicRepository.save(tp);
	}

	public void updateTopic(Topic tp, String id) {
		
	/*	for(int i = 0 ; i < topics.size() ; i++) {  
			topic t = topics.get(i); 
			
			if(t.getId().equals(id)) {  
				
				topics.set(i,tp); 
				
				return ; 
				
			}*/ 
		
		topicRepository.save(tp);
			
		
	}

	public void DeleteTopic(String id) { 
	    //  topics.removeIf(t -> t.getId().equals(id)); 
		
		topicRepository.deleteById(id);
	} 
	
	
	

}
