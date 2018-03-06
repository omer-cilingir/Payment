package com.omer.iyzico.util;

import com.iyzipay.Options;

public class OptionsRetriever {

	private static Options options;
	
	public static Options getOptions(String baseUrl) {
		options = new Options();
        options.setApiKey("sandbox-WJQ1HcphuA9cesK1quRqOko6tBneuy46");
        options.setSecretKey("sandbox-O5HjgLsjdf9iUSOj9FGI03TLVzmni9sA");
		options.setBaseUrl(baseUrl);
		return options;
	}
}
