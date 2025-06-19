package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DelayTest extends BaseTest {
    @Test
    public void testDelayedResponse() {
        try {
            given()
            .when()
                .get("/api/users?delay=3")
            .then()
                .statusCode(200)
                .body("data", notNullValue());
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during Delayed Response Test: " + e.getMessage();
        }
    }
}
