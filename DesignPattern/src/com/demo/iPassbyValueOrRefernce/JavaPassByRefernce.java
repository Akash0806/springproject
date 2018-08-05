package com.demo.iPassbyValueOrRefernce;

import java.util.ArrayList;
import java.util.List;

public class JavaPassByRefernce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog dog=new Dog("Max");
		dog.changeName(dog);
		System.out.println("Name : "+dog.getDogName());
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		dog.addArrayList(list);
		System.out.println(list);

	}

}
