package com.ggktech.rest.client;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;

import com.ggktech.rest.dto.User;

import au.com.dius.pact.consumer.ConsumerPactTestMk2;
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ConsumerTest extends ConsumerPactTestMk2{

	 @Rule
	 public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("test_provider", "localhost", 8080, this);
	 
	@Override
	protected String consumerName() {
		return "user_test";
	}

	@Override
	@Pact(provider="test_provider", consumer="test_consumer")
	protected RequestResponsePact createPact(PactDslWithProvider builder) {
		 return builder
		            .given("test state") // NOTE: Using provider states are optional, you can leave it out
		            .uponReceiving("ExampleJavaConsumerPactTest test interaction")
		                .path("/user")
		                .method("GET")
		            .willRespondWith()
		                .status(200)
		                .body(new PactDslJsonBody().integerType("id", 1).stringValue("name", "John"))
		            .toPact();
	}

	@Override
	protected String providerName() {
		return "user_provide";
	}

	@Override
	protected void runTest(MockServer server) throws IOException {
		RestClient restClient = new RestClient(server.getUrl());
		User user = restClient.getUser();
		Assert.assertNotNull(user);
	}

	
}
