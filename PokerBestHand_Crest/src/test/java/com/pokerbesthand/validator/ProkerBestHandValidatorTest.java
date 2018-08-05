package com.pokerbesthand.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.pokerbesthand.util.ProkerBestHandConstant;
import com.pokerbesthand.validator.ProkerBestHandValidatiorImpl;

/**
 * Compatible with <b>JUnit 4.4 and higher</b>, this runner adds following behavior:
 * <ul>
 *   <li>
 *      Initializes mocks annotated with {@link Mock},
 *      so that explicit usage of {@link MockitoAnnotations#initMocks(Object)} is not necessary. 
 *      Mocks are initialized before each test method.
 *   <li>
 *      validates framework usage after each test method. See javadoc for {@link Mockito#validateMockitoUsage()}.
 * </ul>**/
@RunWith(MockitoJUnitRunner.class)
public class ProkerBestHandValidatorTest {

@InjectMocks
ProkerBestHandValidatiorImpl  prokerBestHandValidatior=new ProkerBestHandValidatiorImpl();

String pokerInput[]=null;




@Before
public void setUp(){
	
}



@Test
public void testInputCountIsValidForSixLengthArray(){
	
	String pokerInput[]={"H2","H5","D7","4D","S8","D9"};
	Assert.assertEquals("Array lenght count should not be less or more then 5",true, prokerBestHandValidatior.isLengthMoreOrLessThenFive(pokerInput));
}
@Test
public void testInputCountIsValidForFiveLengthArray(){
	String pokerInput[]={"H2","H5","D7","S8","D9"};
	Assert.assertEquals("Array lenght count should be 5 ",false, prokerBestHandValidatior.isLengthMoreOrLessThenFive(pokerInput));
}

@Test
public void testErrorForNonExistingSuites(){
	String pokerInput[]={"H2","H5","D7","K8","I5"};
	Assert.assertEquals("Non existing suites e.g K,I ",ProkerBestHandConstant.ERR_NON_EXISTING_SUITS, prokerBestHandValidatior.isFacesAndSuitsAreValid(pokerInput));
	
}

@Test
public void testErrorForNonExistingFaces(){
	String pokerInput[]={"H2","H5","D7","S11","D12"};
	Assert.assertEquals("Non existing Faces e.g 10,11 ",ProkerBestHandConstant.ERR_NON_EXISTING_FACES, prokerBestHandValidatior.isFacesAndSuitsAreValid(pokerInput));
	
}

	
	
	
	
	
}
