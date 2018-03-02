package com.omer.iyzico;

import org.junit.Test;
import static org.junit.Assert.*;

import com.iyzipay.model.BinNumber;
import com.omer.iyzico.checkers.BinNumberCheck;

public class BinNumberTest {
	
	@Test
	public void binNumbercheck() {
		
		BinNumberCheck binNumberCheck=new BinNumberCheck();
		BinNumber binNumber = binNumberCheck.checkBinNumber("554960");
		
		assertEquals(new Long(62), binNumber.getBankCode());
		
	}

}
