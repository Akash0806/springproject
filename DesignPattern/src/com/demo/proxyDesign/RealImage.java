package com.demo.proxyDesign;

public class RealImage implements Image {
	private String fileName;
	
	public RealImage(String fileName){
		this.fileName=fileName;
		locationImage();
		
	}
	
	@Override
	public void display(){
		System.out.println("real image display");
	}

	public void locationImage(){
		System.out.println("Image load"+fileName);
	}

}
