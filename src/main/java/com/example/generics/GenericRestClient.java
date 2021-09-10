package com.example.generics;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GenericRestClient {

	public <K, T> K post(String url, T request, Class<K> clazz) {

		K response =  WebClient.builder().build().post().uri(url).body(BodyInserters.fromValue(request)).retrieve().bodyToMono(clazz).block();
		
		return response;

	}
}
