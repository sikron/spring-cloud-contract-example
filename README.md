# Spring Cloud Contract Demo

A demo to show, how to use Spring Cloud Contract to verify a service's API against a client.

**In contrast to PACT, here the producer drives the testing**. I.e. the contract is defined on the 
producer's side using a Groovy DSL. These contracts are then integrated in the tests of the 
producer, so that it is asserted, that the contracts match the actual behaviour of the producer.

**The clients then can pull those contracts** as maven artifacts and create a mock server. So they
can test independent of the producer.

So basically Spring Cloud Contract provides a equally behaving mock server, whereas PACT asserts that
the services do change APIs and break the clients. **Same same, but different :-)**

## Procedure

1. Build and test the producer. The result are the producer's service artifact and an additional
artifact with "stubs" classifier. See "target/stubs" for the generated JSON contracts. For 
generating those contracts the `spring-cloud-contract-maven-plugin` is used as part of the maven
lifecycle.

    - `cd producer && mvn clean install`
    
2. Run the consumer's tests. Using annotations of spring cloud config a wiremock server is started
and populated with the contracts specified in the annotation using maven coordinates. The client
app then just calls the mock server as it would call the real server and thus perform its tests.

    - `cd consumer && maven clean install`
    
## Resources

  - Examples
    - https://specto.io/blog/2016/11/16/spring-cloud-contract/
    - https://cloud.spring.io/spring-cloud-contract/
  
  - Docu
    - https://cloud.spring.io/spring-cloud-contract/spring-cloud-contract.html
    - https://cloud.spring.io/spring-cloud-contract/spring-cloud-contract-maven-plugin/
    
  - Workshop
    - http://cloud-samples.spring.io/spring-cloud-contract-samples/workshops.html