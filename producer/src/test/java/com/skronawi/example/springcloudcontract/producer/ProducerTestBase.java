package com.skronawi.example.springcloudcontract.producer;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/*
A Base class providing a setup for the automatically generated tests according to the contracts.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApp.class)
public class ProducerTestBase {

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(context);
    }
}
