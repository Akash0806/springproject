package com.demo.mvcDesign;

public class StudentModel {
	
	private String studentName;
	private String rollNumber;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public StudentModel(String studentName, String rollNumber) {
		super();
		this.studentName = studentName;
		this.rollNumber = rollNumber;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	

}
