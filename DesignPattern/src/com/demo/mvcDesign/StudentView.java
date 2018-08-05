package com.demo.mvcDesign;

public class StudentView {
	
	//private StudentModel model;
	
	public StudentView(){
		
	}
	
	public void displayStudentView(StudentModel model){
		System.out.println("Student Name :"+model.getStudentName());
		System.out.println("Student Roll Number :"+model.getRollNumber());
	}
	

}
