package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AccountCreationTest extends BaseTest {
    @Test
    public void testCreateEmployeeAccount() {
        try {
            given()
                .contentType("application/json")
                .body("{\"name\": \"Lakshmi\", \"job\": \"Tester\"}")
            .when()
                .post("/api/users")
            .then()
                .statusCode(201)
                .body("name", equalTo("Lakshmi"))
                .body("job", equalTo("Tester"));
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Account Creation Test: " + e.getMessage();
        }
    }
}
