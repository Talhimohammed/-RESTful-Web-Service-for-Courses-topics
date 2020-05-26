package io.javabrains.springboot.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springboot.Topic.Topic;

@RestController
public class CourseController { 
	
	@Autowired
	private CourseService courseservice ;
	 
	
     
	@RequestMapping("/topics/{id}/courses")
	 public List<Course> getAllCourses(@PathVariable String id) {   
		 return courseservice.getallcourses(id);
	
	 } 
	 @RequestMapping("topics/{topicId}/courses/{id}")
	 public Course getCourse(@PathVariable String id){ 
		 return courseservice.getCourse(id);
	 }   
	 
	 @RequestMapping(method = RequestMethod.POST , value = "/topics/{TopicID}/courses")
	 public void addCourse(@RequestBody Course course , @PathVariable String TopicID) {   
		 course.setTopic(new Topic(TopicID,"","")); 
		 courseservice.addCourse(course);
	 } 
	 
	 @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}/courses")
	 public void UpdateCourse(@RequestBody Course course ,  @PathVariable String TopicID ,@PathVariable String id ) {   
		 course.setTopic(new Topic(TopicID,"","")); 
		 courseservice.updateCourse(course);
	 } 
	 
	 @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicID}/courses/{id}")
	 public void DeleteCourse(@PathVariable String id ) {  
		 courseservice.Deletecourse(id);
	 } 
	 
	 
	 
	 
	 
	 
	 
}
