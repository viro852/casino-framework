package com.slotegrator.framework.api.actions;

import com.slotegrator.framework.api.specifiations.Specifications;
import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.utils.PropConsts;
import com.slotegrator.framework.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;

public class Player extends BasePage {

    public Player successGuestTokenReceipt(String login, String pass) {
        Response response = RestAssured
                .given()
                .spec(Specifications.getSuccessGuestAuthorizationReqSpec(propertyManager.getProperty(PropConsts.BASE_API_URL)))
                .auth().preemptive().basic(login, pass)
                .when()
                .post("v2/oauth2/token")
                .then()
                .spec(Specifications.getSuccessGuestAuthorizationRespSpec())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.get("access_token");
        String tokenType = jsonPath.get("token_type");

        Assertions.assertTrue(StringUtils.isNotBlank(token));
        Assertions.assertEquals("Bearer", tokenType);

        Utils.writeDataToFile("guest_auth_token", tokenType + " " + token);

        return this;
    }

    public Player successRegistration(String suffix) {
        Response response = RestAssured
                .given()
                .spec(Specifications.getSuccessRegistrationReqSpec(propertyManager.getProperty(PropConsts.BASE_API_URL), suffix))
                .when()
                .post("v2/players")
                .then()
                .spec(Specifications.getSuccessRegistrationResSpec())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertTrue(
                StringUtils.isNotBlank(String.valueOf(jsonPath.getInt("id")))
        );

        Assertions.assertTrue(
                StringUtils.isNotBlank(jsonPath.getString("username"))
                        &&
                        jsonPath.getString("username").contains(suffix)

        );

        Assertions.assertTrue(
                StringUtils.isNotBlank(jsonPath.getString("email"))
                        &&
                        jsonPath.getString("email").contains(suffix)
        );

        Utils.writeDataToFile("SuffixOfPlayerAttributes", suffix);
        Utils.writeDataToFile("registeredPlayerId", String.valueOf(jsonPath.getInt("id")));

        return this;
    }

    public Player successAuthorizationByCreatedPlayer(String login, String pass) {

        Response response = RestAssured
                .given()
                .spec(Specifications.getSuccessPlayerAuthorizationReqSpec(propertyManager.getProperty(PropConsts.BASE_API_URL)))
                .auth().preemptive().basic(login, pass)
                .when()
                .post("v2/oauth2/token")
                .then()
                .spec(Specifications.getSuccessPlayerAuthorizationRespSpec())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("access_token");
        String tokenType = jsonPath.getString("token_type");

        Assertions.assertTrue(StringUtils.isNotBlank(token));
        Assertions.assertEquals("Bearer", tokenType);

        Utils.writeDataToFile("player_auth_token", tokenType + " " + token);

        return this;
    }

    public Player successPlayerProfileDataReceipt(String id, String suffix) {

        Response response = RestAssured
                .given()
                .spec(Specifications.getSuccessPlayerProfileDataReqSpec(propertyManager.getProperty(PropConsts.BASE_API_URL)))
                .when()
                .get("v2/players/" + id)
                .then()
                .spec(Specifications.getSuccessPlayerProfileDataRespSpec())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertTrue(
                StringUtils.isNotBlank(jsonPath.getString("username"))
                        &&
                        jsonPath.getString("username").equals("test" + suffix)

        );

        Assertions.assertTrue(
                StringUtils.isNotBlank(jsonPath.getString("email"))
                        &&
                        jsonPath.getString("email").equals("automation" + suffix + "@example.com")
        );

        return this;
    }

    public Player unsuccessPlayerProfileDataReceipt(String id) {

        Response response = RestAssured
                .given()
                .spec(Specifications.getUnsuccessPlayerProfileDataReqSpec(propertyManager.getProperty(PropConsts.BASE_API_URL)))
                .when()
                .get("v2/players/" + id + "")
                .then()
                .spec(Specifications.getUnsuccessPlayerProfileDataRespSpec())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String msq=jsonPath.getString("message");

        Assertions.assertEquals("Object not found: "+id+"", msq);

        return this;
    }
}
