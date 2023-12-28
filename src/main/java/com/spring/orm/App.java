package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao dao =  (StudentDao) context.getBean("studentDao");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) {
        	 System.out.println("PRESS 1 for add new studnt in database");
             System.out.println("PRESS 2 for display all student from database");
             System.out.println("PRESS 3 for getting the details of single student");
             System.out.println("PRESS 4 for delete student");
             System.out.println("PRESS 5 for update student");
             System.out.println("PRESS 6 for exit");
             System.out.println();
             
             try {
            	 
            	 int input = Integer.parseInt(br.readLine());
            	 
            	
            	 switch(input) {
            	 
            	 case 1:
            		 // add a new student
            		System.out.println("Enter student id : ");
            		int uId = Integer.parseInt(br.readLine());
            		
            		System.out.println("Enter student name : ");
            		String uName = br.readLine();
            		
            		System.out.println("Enter student city : ");
            		String sCity = br.readLine();
            		
            		Student student = new Student();
            		student.setStudentId(uId);
            		student.setStudentName(uName);
            		student.setStudentCity(sCity);
            		
            		
            		int r = dao.insert(student);
            		System.out.println("total number of student in database : " + r);
            		System.out.println("--------------------------------------------------------------------------------");
            		System.out.println();
            		
            		
            		
            		 break;
            		 
            		 
            	 case 2:
            		 // display all the student
            		 
            		 List<Student> studentList = dao.getAllStudents();
            		 for(Student s : studentList) {
            			 System.out.println("--------------------------------------------------------------------------------");
            			 System.out.println();
            			 System.out.println("Name : " + s.getStudentName());
            			 System.out.println("city : " + s.getStudentCity());
            			 System.out.println("ID : " + s.getStudentId());
            			 System.out.println();
            			 System.out.println("--------------------------------------------------------------------------------");
            			 
            		 }
            		 break;
            		 
            		 
            	 case 3:
            		 // get a details of single student
            		 System.out.println("enter a student id for details : ");
            		 int i = Integer.parseInt(br.readLine());
            		 Student s = dao.getStudent(i);
            		 System.out.println("Name : " + s.getStudentName());
        			 System.out.println("city : " + s.getStudentCity());
        			 System.out.println("ID : " + s.getStudentId());
            		 break;
            		 
            		 
            	 case 4:
            		 // delete a student
            		 System.out.println("enter the student id for deleting ");
            		 int e = Integer.parseInt(br.readLine());
            		 dao.deleteStudent(e);
            		 System.out.println("ttudent id " + e + " has been deleted  !! ");
            		 
            		 break;
            	 
            		 
            	 case 5:
            		 //update a student
            		 
            		 System.out.println("Enter the Student id to update: ");
         			int updId = Integer.parseInt(br.readLine());
         			System.out.println("PRESS 1 to update Name");
         			System.out.println("PRESS 2 to update City");
         			int nameOrCity = Integer.parseInt(br.readLine());
         			Student student1 = dao.getStudent(updId);
         			String updatedName = student1.getStudentName();
         			String updatedCity = student1.getStudentCity();
         			
         			switch (nameOrCity) {
         				case 1:
             				System.out.println("Enter the Name to be updated: ");
             				updatedName = br.readLine();
             				student1 = new Student(updId, updatedName, updatedCity);
             				break;
         				case 2:
             				System.out.println("Enter the City to be updated: ");
             				updatedCity = br.readLine();
             				student1 = new Student(updId, updatedName, updatedCity);
         					break;				
         			}
         			dao.updateStudent(student1);
         			System.out.println("Updated student Details Successfully!");
            		 
            		 break;
            		 
            		 
            	 case 6:
            		 // exit from application 
            		 go = false;
            		 break;
            	 
            	 }
            	 
				
			} catch (Exception e) {
				System.out.println("INVALID INPUT .......");
				System.out.println(e.getMessage());
			}
        }
       
        System.out.println("thankyou for using the application have a good day :-) ");
        
       
    }
}
