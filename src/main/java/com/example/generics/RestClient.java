package com.example.generics;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestClient {

	public String getMessage(String input) {

		String response = WebClient.builder().build().post().uri("http://localhost:8080/getMessage")
				.body(BodyInserters.fromValue(input)).retrieve().bodyToMono(String.class).block();

		return response;

	}

	public Map<String, String> getMessageMap(Map<String, String> input) {

		Map<String, String> response = WebClient.builder().build().post().uri("http://localhost:8080/getMessageMap")
				.body(BodyInserters.fromValue(input)).retrieve().bodyToMono(Map.class).block();

		return response;

	}

	public MyResponseObject getMessage(MyRequestObject input) {

		MyResponseObject response = WebClient.builder().build().post().uri("http://localhost:8080/getMessageObject")
				.body(BodyInserters.fromValue(input)).retrieve().bodyToMono(MyResponseObject.class).block();

		return response;

	}
}
