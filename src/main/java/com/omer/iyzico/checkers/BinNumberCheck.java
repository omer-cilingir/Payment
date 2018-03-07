package com.omer.iyzico.checkers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iyzipay.model.BinNumber;
import com.iyzipay.request.RetrieveBinNumberRequest;
import com.omer.iyzico.util.OptionsRetriever;

@Component
public class BinNumberCheck {
	
	@Autowired
	OptionsRetriever optionsRetriever;

	public BinNumberCheck() {
	}

	public BinNumber checkBinNumber(String binNumber) {

		RetrieveBinNumberRequest request = new RetrieveBinNumberRequest();
		// request.setLocale(Locale.TR.getValue());
		// request.setConversationId("123456789");
		request.setBinNumber(binNumber);

		return BinNumber.retrieve(request, optionsRetriever.getOptions());
	}
}
