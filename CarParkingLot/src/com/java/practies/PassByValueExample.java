package com.java.practies;

public class PassByValueExample {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         //Dog d = new Dog("Don");
		Dog dog=new Dog("Don");
		PassByValueExample p=new PassByValueExample();
		System.out.println(dog.hashCode());
		p.foo(dog);
		System.out.println(dog.getName());
		System.out.println(dog.hashCode());
         
	}
	
	public void foo(Dog d){
		d.setName("MAX");
		d=new Dog("Txt");
		
	}

	
	
}
