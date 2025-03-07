package com.konfigthis.client;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

public class SimpleTest {
    final String MOCK_SERVER_URL = "http://localhost:4010";

    @Test
    public void initClientTest() {
        Configuration configuration = new Configuration();
        configuration.host = "https://api.factorialhr.com/api";
        
        configuration.apikey  = "YOUR API KEY";
        
        // Configure OAuth2 access token for authorization: oauth2
        configuration.accessToken = "YOUR ACCESS TOKEN";
        Factorial client = new Factorial(configuration);
        assertNotNull(client);
    }
}
