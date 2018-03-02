package com.omer.iyzico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iyzipay.model.BinNumber;
import com.omer.iyzico.checkers.BinNumberCheck;
import com.omer.iyzico.checkers.PaymentCheck;
import com.omer.iyzico.model.Request;

@RestController
@RequestMapping("/")
public class PaymentController {

	Gson gson = new Gson();

	@Autowired
	PaymentCheck paymentCheck;

	@RequestMapping(path = "/payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String payment(@RequestBody Request request) {
		return paymentCheck.payment(request);
	}

	@RequestMapping(path = "/getBinNumber", produces = MediaType.APPLICATION_JSON_VALUE)
	public BinNumber binNumber(@RequestParam String binNumber) {
		return new BinNumberCheck().checkBinNumber(binNumber);
	}
}