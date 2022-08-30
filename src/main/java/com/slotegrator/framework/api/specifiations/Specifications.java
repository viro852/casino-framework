package com.slotegrator.framework.api.specifiations;

import com.slotegrator.framework.utils.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification getSuccessGuestAuthorizationReqSpec(String baseUrl) {
        String requestBody = Utils.readDataFromFile("getGuestTokenBody.json");

        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .setBody(requestBody)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getSuccessGuestAuthorizationRespSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getSuccessRegistrationReqSpec(String baseUrl, String suffix) {
        String requestBody = Utils.readDataFromFile("successPlayerRegistration.json");
        requestBody = requestBody.replace("{replace}", suffix);

        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization", Utils.readDataFromFile("guest_auth_token.txt"))
                .setContentType("application/json")
                .setBody(requestBody)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getSuccessRegistrationResSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(201)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getSuccessPlayerAuthorizationReqSpec(String baseUrl) {
        String requestBody = Utils.readDataFromFile("getPlayerTokenBody.json");
        requestBody = requestBody.replace("{replace}", Utils.readDataFromFile("SuffixOfPlayerAttributes.txt"));

        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")  
                .setBody(requestBody)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getSuccessPlayerAuthorizationRespSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getSuccessPlayerProfileDataReqSpec(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization",Utils.readDataFromFile("player_auth_token.txt"))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getSuccessPlayerProfileDataRespSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification getUnsuccessPlayerProfileDataReqSpec(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("Authorization",Utils.readDataFromFile("player_auth_token.txt"))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getUnsuccessPlayerProfileDataRespSpec() {
        return new ResponseSpecBuilder()
                .expectContentType("application/json")
                .expectStatusCode(404)
                .log(LogDetail.ALL)
                .build();
    }
}
