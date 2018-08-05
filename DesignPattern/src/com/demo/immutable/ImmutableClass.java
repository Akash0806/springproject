package com.demo.immutable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class ImmutableClass {
	
	
	private final String name;
	private final Integer age;
	private final Date dateofBirth;
	private final MutableClass mutableClass;
	private final List<String> modifiableList;
	
	
	public ImmutableClass(String namea,Integer age,Date dateofBirth,MutableClass mutableClass,List<String> modifiableList){
		this.name=namea;
		this.age=age;
		this.dateofBirth=new Date(dateofBirth.getTime());
	    this.mutableClass=new MutableClass(mutableClass.getMutableClassName());
	    this.modifiableList=modifiableList;
   }
	
	public static ImmutableClass getImmutableClassInstance(String name,Integer age,Date dob,MutableClass MutableClass,List<String> modifiableList){
		return new ImmutableClass(name,age,dob,MutableClass,modifiableList);
	}
		
	
	public String getName() {
		return name;
	}
	public Integer  getAge() {
		return age;
	}
	public Date getDateofBirth() {
		return new Date(dateofBirth.getTime());
	}
	
    public MutableClass getMutableClass(){
    	return new MutableClass(mutableClass.getMutableClassName());
    	//return mutableClass;
    }
    public List<String> getModifiableList(){
    	return  Collections.unmodifiableList(modifiableList);
    }

	@Override
	public String toString() {
		return "ImmutableClass [name=" + name + ", age=" + age + ", dateofBirth=" + dateofBirth + ", mutableClass="
				+ mutableClass.getMutableClassName() +"modifiableList= "+Arrays.toString(modifiableList.toArray())+ "]";
	}
	
	
	}
