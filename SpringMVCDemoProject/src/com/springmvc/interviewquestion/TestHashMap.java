package com.springmvc.interviewquestion;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public static void main(String[] args) {
		String s1="abc";
		String s2=new String("abc");
		String s3="abc";
		
		System.out.println(System.identityHashCode(s1)+"==="+System.identityHashCode(s2)+"=S3==="+System.identityHashCode(s3));
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String,String>();
		map.put("abc","123");
		System.out.println("!1: st  "+map.get(s1));
		System.out.println("!1: st  "+map.get(s2));
		
	}

}
