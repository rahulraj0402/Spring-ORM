package com.spring.orm.dao;
import java.util.*;
import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public int insert(Student student) {
		
		Integer r = (Integer)this.hibernateTemplate.save(student);
		
		return r;
	}
	
	// get the single object  or data 
	public Student getStudent(int id) {
		
		return this.hibernateTemplate.get(Student.class , id);
		
	}
	
	
	
	
	
	
	
	
	
	// get all the data means all the student objects 
	public List<Student> getAllStudents(){
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	
	
	
	
	
	
	
	//deleting the data 
	@Transactional
	public void deleteStudent(int id) {
		// first get the student object which you want to delete 
		Student student = this.hibernateTemplate.get(Student.class, id);
		// now use hibernate tempalate to use the delete function 
		
		this.hibernateTemplate.delete(student);
		
	}
	
	
	
	
	//update the name using the student id
	@Transactional
	public void updateStudent(Student student) {
		
		
		this.hibernateTemplate.update(student);
	}
	
	
	
	
	
	
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
