package com.billgenration.item.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestInputUtil {
	InputUtil inputUtil=null;
	@Before
	public void setUp() throws Exception {
		inputUtil=new InputUtil();
	}

	@Test
	public void testGetInputStrintsWhenInputNull() {
		Assert.assertTrue(inputUtil.getInputStrintsFromCSV(null).size()==0);
		
	}
	
	@Test
	public void testGetInputStrintsWhenInputEmpty() {
		Assert.assertTrue(inputUtil.getInputStrintsFromCSV("").size()==0);
	}
	
	@Test
	public void testGetInputStrintsWhenInputFileIsNotAvailble() {
		Assert.assertTrue(inputUtil.getInputStrintsFromCSV("/abc.csv").size()==0);
	}


}
