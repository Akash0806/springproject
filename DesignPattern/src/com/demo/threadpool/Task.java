package com.demo.threadpool;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	
	public String name;
	
	public Task(String threadName){
		this.name=threadName;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	double duration=Math.random()*10;
	try {
		  System.out.println("Doing a task during : " + name);
          TimeUnit.SECONDS.sleep((long) duration);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

}
