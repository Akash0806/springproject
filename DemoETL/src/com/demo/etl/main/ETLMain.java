package com.demo.etl.main;

public class ETLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a='A';
		int z='Z';
		int a1='a';
		int z1='z';
       System.out.println("small a :"+a1);
       System.out.println("small z :"+z1);
       System.out.println("capital A :"+a);
       System.out.println("capital Z :"+z);
       String str="*aash";
       char test=str.charAt(0);
       StringBuilder sb=new StringBuilder();
       if(test>='a' || 'z'<test){
    	   char newChar=(char)(test-32);
    	    
    	   String cap = newChar+ str.substring(1);
    	   System.out.println(cap);
       }
       
       
       
	}

}
