package com.demo.immutable;

public class MutableClass {
	
	private String mutableClassName;
	
	

	public MutableClass(String mutableClassName) {
		super();
		this.mutableClassName = mutableClassName;
	}

	public String getMutableClassName() {
		return mutableClassName;
	}

	public void setMutableClassName(String mutableClassName) {
		this.mutableClassName = mutableClassName;
	}
	
	

}
