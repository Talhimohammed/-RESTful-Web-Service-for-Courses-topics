package io.javabrains.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService { 
	
	
	@Autowired
	private CourseRepository topicRepository ;  
	
	 
	
	public List<Course> getallcourses(String topicId){ 
		 List<Course> courses = new ArrayList<>();
		 topicRepository.findByTopicId(topicId)
		 .forEach(courses::add);
		 return courses ; 
	} 
	
	public Course getCourse(String id){ 
	  
		Course a = null ; 
		if(topicRepository.findById(id).isPresent()) {
		return (topicRepository.findById(id)).get();  
		
		}else { 
		return a ;  
		
		}
		
	}

	public void addCourse(Course course) {
		 topicRepository.save(course);
	}

	public void updateCourse(Course course) {
		
	/*	for(int i = 0 ; i < topics.size() ; i++) {  
			topic t = topics.get(i); 
			
			if(t.getId().equals(id)) {  
				
				topics.set(i,tp); 
				
				return ; 
				
			}*/ 
		
		topicRepository.save(course);
			
		
		
	}

	public void Deletecourse(String id) { 
	    //  topics.removeIf(t -> t.getId().equals(id)); 
		
		topicRepository.deleteById(id);
	} 
	
	
	

}
