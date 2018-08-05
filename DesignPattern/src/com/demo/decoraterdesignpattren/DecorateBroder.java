package com.demo.decoraterdesignpattren;

public abstract class DecorateBroder implements Shape{
	
	Shape shape;
	
	public DecorateBroder(){
		
	}
	
	public DecorateBroder(Shape shape){
		this.shape=shape;
	}
	
	abstract void addRedBroder();

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		shape.draw();
	}

}
