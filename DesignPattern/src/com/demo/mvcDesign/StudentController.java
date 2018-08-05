package com.demo.mvcDesign;

public class StudentController {
	private StudentModel model;
	private StudentView studentView;
	
	public StudentController(StudentModel model,StudentView studentView){
		this.model=model;
		this.studentView=studentView;
	}
	
	public void getStudentDetails(){
		studentView.displayStudentView(model);
	}

}
