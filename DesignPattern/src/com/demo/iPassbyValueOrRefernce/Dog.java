package com.demo.iPassbyValueOrRefernce;

import java.util.List;

public class Dog {

	private String dogName;
	
	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public Dog(String dogName){
		this.dogName=dogName;
	}
	
	public void changeName(Dog dog){
		dog=new Dog("SuperMax");
		System.out.println("in side change name : "+dog.dogName);
		
	}
	
	public void swapName(){
		
	}
	
	public void addArrayList(List<Integer> arrayList){
		arrayList.add(1);
		arrayList.add(2);
		
	}
	
	
}
