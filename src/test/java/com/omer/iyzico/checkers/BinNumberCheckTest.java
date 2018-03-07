package com.omer.iyzico.checkers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyzipay.model.BinNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BinNumberCheckTest {
	
	@Autowired
	private BinNumberCheck binNumberCheck;
	
	@Test
	public void binNumbercheck() {
		
		BinNumber binNumber = binNumberCheck.checkBinNumber("554960");
		
		assertEquals(new Long(62), binNumber.getBankCode());
		
	}

}
