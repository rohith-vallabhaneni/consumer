package com.ggktech.rest.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ggktech.rest.dto.User;

@Component
public class RestClient {

	private RestTemplate restTemplate;
	private String restUrl;

	public RestClient(String restUrl) {
		this.restUrl = restUrl;
		restTemplate = new RestTemplate();
	}

	public User getUser() {
		User user=null;
		try {
			user = restTemplate.getForObject(restUrl + "/user", User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
