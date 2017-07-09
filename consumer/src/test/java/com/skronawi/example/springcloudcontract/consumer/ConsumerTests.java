package com.skronawi.example.springcloudcontract.consumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Set;

@RunWith(SpringRunner.class)
//start the consumer app in-memory according to the application.properties
@SpringBootTest(classes = ConsumerApp.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//start the wiremock with the contracts provided by the producer artifact. for now only pull from local repo!
@AutoConfigureStubRunner(
        ids = "org.springframework.boot:spring-cloud-contract-demo-producer:+:stubs:8080",
        workOffline = true)
public class ConsumerTests {

    @Test
    public void validate_getUserReturnsVeit() throws Exception {

        ResponseEntity<Set> usersResponse = new RestTemplate().getForEntity(
                URI.create("http://localhost:8081"), Set.class);
        Set userNames = usersResponse.getBody();

        Assert.assertEquals(1, userNames.size());
        Assert.assertTrue(userNames.contains("veit"));
    }
}
