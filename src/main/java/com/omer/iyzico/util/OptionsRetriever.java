package com.omer.iyzico.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.iyzipay.Options;

@Component
public class OptionsRetriever {
	
	@Autowired
	private Environment env;

	private static Options options;

	public Options getOptions() {

		if (options == null) {
			options = new Options();
			options.setApiKey(env.getProperty("ticket.payment.api.key"));
			options.setSecretKey(env.getProperty("ticket.payment.api.secret.key"));
			options.setBaseUrl(env.getProperty("ticket.payment.api.base.url"));
		}
		return options;
	}
}
