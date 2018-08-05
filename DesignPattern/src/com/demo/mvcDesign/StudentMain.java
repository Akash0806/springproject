package com.demo.mvcDesign;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentModel studentModel=new StudentModel("Ramesh", "0817CS41007");
		StudentView studentView=new StudentView();
		StudentController controller=new StudentController(studentModel, studentView);
        controller.getStudentDetails();
	}

}
