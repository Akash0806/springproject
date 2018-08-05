package com.pokerbesthand.controller;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pokerbesthand.controller.PokerHandResultAnaliyzer;
import com.pokerbesthand.enumconstant.PokerHandType;
import com.pokerbesthand.service.PokerHandResultProducer;
import com.pokerbesthand.util.ProkerBestHandConstant;
import com.pokerbesthand.validator.ProkerBestHandValidatior;

@RunWith(MockitoJUnitRunner.class)
public class PokerHandResultAnaliyzerTest {
	
	private static final String STRING_HIGH_END = "H2 H5 D7 S8 D9";

	private static final String[] ARRAY_HIGH_END = {"H2","H5","D7","S8","D9"};

	private static final String[] ARRAY_THREE_OF_A_KIND = {"H2", "D2", "S2" ,"SK", "DQ"};

	private static final String STRING_THREE_OF_A_KIND_INPUT = "H2 D2 S2 SK DQ";
	
	private static final String STRING_FULL_HOUSE= "H2 H3 D2 S3 D3";
	
	private static final String[] ARRAY_FULL_HOUSE={"H2","H3","D2","S3","D3"};
	
	private static final String STRING_TWO_PAIR="H2 H7 D2 S3 D3";
	
	private static final String[] ARRAY_TWO_PAIR={"H2","H7","D2","S3","D3"};
	
	private static final String STRING_FOUR_OF_A_KIND="H2 H7 D7 S7 C7";
	
	private static final String[] ARRAY_FOUR_OF_A_KIND={"H2","H7","D7","S7","C7"};
	
	private static final String STRING_ONE_PAIR= "H4 C4 CK D5 CT";
	
	private static final String[] ARRAY_ONE_PAIR={"H4","C4","CK","D5","CT"};
	
	private static final String STRING_STRAIGHT ="HK DQ SJ ST SA";
			
	private static final String[] ARRAY_STRAIGHT={"HK", "DQ","SJ","ST","SA"};
	
	
	private static final String STRING_FLUSH="CQ CT C7 C6 C4";
	
	private static final String[] ARRAY_FLUSH={"CQ","CT", "C7" ,"C6","C4"};
	
	 

	@InjectMocks
	PokerHandResultAnaliyzer pokerHandResultAnaliyzer=new PokerHandResultAnaliyzer();
	
	@Mock
	ProkerBestHandValidatior prokerBestHandValidatior;
	
	@Mock
	PokerHandResultProducer pokerHandResultProducer;
	
	@Test
	public void testResultMsgIsNotEmptyIfValidationResultIsError(){
		String inputCard="";
		String[] pokerInput={""};
		Mockito.when(prokerBestHandValidatior.validation(pokerInput)).thenReturn(ProkerBestHandConstant.ERR_INVAILD_HANDS);
		String resultMsg=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(inputCard);
		Assert.assertEquals("Input should be vaild", ProkerBestHandConstant.ERR_INVAILD_HANDS, resultMsg);
	}
	
	@Test
	public void testFaceCountArrayLegnthMorethenOne(){
    @SuppressWarnings("rawtypes")
	Map actualMap= pokerHandResultAnaliyzer.getFaceCountAndStraightFlushResult(ARRAY_THREE_OF_A_KIND);
	int[] faceCount = (int[])actualMap.get(ProkerBestHandConstant.FACE_COUNT);
    boolean actual_isStraight	=(Boolean)actualMap.get(ProkerBestHandConstant.IS_STRAIGHT);
    boolean is_Flush=(Boolean)actualMap.get(ProkerBestHandConstant.IS_FLUSH);
	Assert.assertEquals("Face Count should 3 for element 12",faceCount[12],ProkerBestHandConstant.THREE);
	Assert.assertEquals("Straight  should be false ",actual_isStraight,false);
	Assert.assertEquals("Flush  should be false ",is_Flush,false);
	
	}
	
	@Test
	public void testisStraightShouldBeTrue(){
	String[] pokerInput={"HA", "D2", "S3" ,"S4", "D5"};
	@SuppressWarnings("rawtypes")
	Map actualMap= pokerHandResultAnaliyzer.getFaceCountAndStraightFlushResult(pokerInput);
	boolean actual_isStraight	=(Boolean)actualMap.get(ProkerBestHandConstant.IS_STRAIGHT);
    boolean is_Flush=(Boolean)actualMap.get(ProkerBestHandConstant.IS_FLUSH);
	Assert.assertEquals("Straight  should be true ",actual_isStraight,true);
	Assert.assertEquals("Flush  should be false ",is_Flush,false);
	}
	
	
	@Test
	public void testisFlushShouldBeTrue(){
	String[] pokerInput={"CQ", "CT", "C7" ,"C6", "C4"};
	@SuppressWarnings("rawtypes")
	Map actualMap= pokerHandResultAnaliyzer.getFaceCountAndStraightFlushResult(pokerInput);
	boolean actual_isStraight	=(Boolean)actualMap.get(ProkerBestHandConstant.IS_STRAIGHT);
    boolean is_Flush=(Boolean)actualMap.get(ProkerBestHandConstant.IS_FLUSH);
	Assert.assertEquals("Straight  should be false ",actual_isStraight,false);
	Assert.assertEquals("Straight  should be true ",is_Flush,true);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturnThree_Of_A_KIND(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_THREE_OF_A_KIND)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_THREE_OF_A_KIND_INPUT);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_THREE_OF_A_KIND);
		Assert.assertEquals("Result Should be Three_Of_A_KIND",PokerHandType.THREE_OF_A_KIND.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_HIGH_CARD(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_HIGH_END)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_HIGH_END);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_HIGH_END);
		Assert.assertEquals("Result Should be High Card",PokerHandType.HIGH_CARD.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_FULL_HOUSE(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_FULL_HOUSE)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_FULL_HOUSE);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_FULL_HOUSE);
		Assert.assertEquals("Result Should be FULL HOUSE",PokerHandType.FULL_HOUSE.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_TWO_PAIR(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_TWO_PAIR)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_TWO_PAIR);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_TWO_PAIR);
		Assert.assertEquals("Result Should be TWO PAIR",PokerHandType.TWO_PAIR.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_FOUR_OF_A_KIND(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_FOUR_OF_A_KIND)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_FOUR_OF_A_KIND);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_FOUR_OF_A_KIND);
		Assert.assertEquals("Result Should be FOUR OF A KIND",PokerHandType.FOUR_OF_A_KIND.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_STRAIGHT(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_STRAIGHT)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_STRAIGHT);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_STRAIGHT);
		Assert.assertEquals("Result Should be STRAIGHT",PokerHandType.STRAIGHT.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_FLUSH(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_FLUSH)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_FLUSH);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_FLUSH);
		Assert.assertEquals("Result Should be FLUSH",PokerHandType.FLUSH.toString(),actualResult);
	}
	
	@Test
	public void testPokerBestHandResultAnaliyzerShouldReturn_PAIR(){
		Mockito.when(prokerBestHandValidatior.validation(ARRAY_ONE_PAIR)).thenReturn(ProkerBestHandConstant.EMPTY_STRING);
		String actualResult=pokerHandResultAnaliyzer.pokerBestHandResultAnaliyzer(STRING_ONE_PAIR);
		Mockito.verify(prokerBestHandValidatior,Mockito.times(1)).validation(ARRAY_ONE_PAIR);
		Assert.assertEquals("Result Should be PAIR",PokerHandType.PAIR.toString(),actualResult);
	}
	
	
	

}
