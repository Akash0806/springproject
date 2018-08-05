package com.demo.proxyDesign;

public class ProxyMainTest {
	
	static {
		System.out.println("Test Static block ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Image image=new ProxyImage("load from disk");
		image.display();
		
		image.display();

	}

}
