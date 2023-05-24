package com.ericsson.service;




//public class SonarQubeServiceTest {
//
//    private static final String SONARQUBE_URL = "http://localhost:9000";
//    private static final String AUTHORIZATION_HEADER = "Bearer your-access-token";
//
//    @Test
//    public void testGetIssues() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Set the authorization header
//        restTemplate.getInterceptors().add((request, body, execution) -> {
//            request.getHeaders().set("Authorization", AUTHORIZATION_HEADER);
//            return execution.execute(request, body);
//        });
//
//        String apiUrl = SONARQUBE_URL + "/api/issues/search";
//
//        // Perform the API request
//        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class,
//                () -> restTemplate.getForObject(apiUrl, String.class));
//
//        // Assert that the error code is 401
//        assertEquals(401, exception.getRawStatusCode());
//    }
//}

