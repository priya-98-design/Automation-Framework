package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProfileUpdateTest extends BaseTest {
    @Test
    public void testProfileUpdate() {
        try {
            given()
                .contentType("application/json")
                .body("{\"name\": \"Lakshmi Priya\", \"job\": \"Lead QA\"}")
            .when()
                .put("/api/users/2")
            .then()
                .statusCode(200)
                .body("name", equalTo("Lakshmi Priya"))
                .body("job", equalTo("Lead QA"));
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Profile Update Test: " + e.getMessage();
        }
    }
}