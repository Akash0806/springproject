package com.demo.immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestImmutability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ImmutableClass immutableClass=new ImmutableClass("a", 123, new Date());
		immutableClass.getDateofBirth().setDate(11);*/
		MutableClass mutableClass=new MutableClass("mutableClass");
		List<String>list=new ArrayList<String>();
		ImmutableClass immutableClass=ImmutableClass.getImmutableClassInstance("a", 123, new Date(),mutableClass,list);
		immutableClass.getDateofBirth().setDate(10);
		//mutableClass.setMutableClassName("mutableClass2");
		ImmutableClass class1=new ImmutableClass("B",234,new Date(), mutableClass,list);
		class1.getMutableClass().setMutableClassName("aaa");
		class1.getModifiableList().add("a");
		System.out.println(class1.toString());

	}

}
