package com.example.generics;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenericsApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(GenericsApplication.class, args);
	}

	@Autowired
	private RestClient client;

	@Autowired
	private GenericRestClient genericClient;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// ******************** WITHOUT GENERICS *********************//

		String response = client.getMessage("hello");
		System.out.println(response);

		Map<String, String> request = new HashMap<>();
		request.put("message", "hello");
		Map responseMap = client.getMessageMap(request);
		System.out.println(responseMap);

		MyRequestObject requestObj = new MyRequestObject();
		requestObj.setId(1);
		requestObj.setMessage("Hello");

		MyResponseObject responseObj = client.getMessage(requestObj);

		System.out.println(responseObj);

		// ****************** USING GENERICS **************************//

		
		String response2 = genericClient.post("http://localhost:8080/getMessage","hello",String.class);
		System.out.println(response2);


		Map responseMap2 =genericClient.post("http://localhost:8080/getMessageMap", request, Map.class);
		System.out.println(responseMap2);


		MyResponseObject responseObj2 = genericClient.post("http://localhost:8080/getMessageObject", requestObj, MyResponseObject.class);

		System.out.println(responseObj2);

	}

}
