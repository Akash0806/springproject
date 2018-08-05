package com.pokerbesthand.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.powermock.reflect.internal.WhiteboxImpl;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ProkerBestHandValidatiorImpl.class)
public class PokerBestHandValidatorPrivateMethodTest {
	
	@Test
	public void test_private_method() throws Exception{
		ProkerBestHandValidatiorImpl name = new ProkerBestHandValidatiorImpl();
		String sr[]={"2D","2D","4D","KD"};
		boolean result=WhiteboxImpl.invokeMethod(name, "isDuplicateElementsAreAvailable", sr);
				
				//invokeMethod(ProkerBestHandValidatiorImpl.class, "isDuplicateElementsAreAvailable", sr);
		System.out.println(result);
	}

}
