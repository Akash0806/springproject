package com.concretepage.app.spring4soap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.concretepage.soap.Student;

@Component
public class StudentUtility {
	Map<Integer,Student> studentMap=null;  
	public StudentUtility() {
		// TODO Auto-generated constructor stub
		studentMap=new HashMap<Integer, Student>();
		Student s1=new Student();
		s1.setName("A");
		s1.setAge(20);
		s1.setStudentId(001);
		s1.setClazz("12th");
		studentMap.put(1, s1);
		Student s2=new Student();
		s2.setName("B");
		s2.setAge(23);
		s2.setStudentId(002);
		s2.setClazz("11th");
		studentMap.put(2, s2);
		
	}

	public Student getStudent(int studentId){
		return studentMap.get(studentId);
	}

}
