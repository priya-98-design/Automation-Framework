package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthHelper {
    public static String getAuthToken() {
        Response response = given()
                .contentType("application/json")
                .body("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}")
                .when()
                .post("https://reqres.in/api/login");

        response.then().statusCode(200);
        return response.jsonPath().getString("token");
    }
}
