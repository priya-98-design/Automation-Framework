package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        try {
            given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
            .when()
                .post("/api/login")
            .then()
                .statusCode(200)
                .body("token", notNullValue());
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Successful Login Test: " + e.getMessage();
        }
    }

    @Test
    public void testLoginFailure() {
        try {
            given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\"}")
            .when()
                .post("/api/login")
            .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Login Failure Test: " + e.getMessage();
        }
    }
}