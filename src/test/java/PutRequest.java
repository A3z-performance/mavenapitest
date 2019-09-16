import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class PutRequest extends TestConfig {

    @Test
    public void verifyUpdateUserDetails() {
        try {
            given()
                    .header("Content-Type", "application/json")
                    .body(userPersonalDetailsPayload)
            .when()//.log().all()
                    .put(Resources.getUser2EndPointUri())
            .then()
                    .statusCode(HttpStatus.SC_OK).log().all();
        } catch ( Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case:" +  e.getMessage());
        }
    }


    @Test
    public void verifyRegisterSuccessful() {
        try {
            given()
                    .header("Content-Type", "application/json")
                    .body(invalidUserData)
                    .when()//.log().all()
                    .post(Resources.postRegisterProcess())
                    .then().assertThat()
                    .statusCode(HttpStatus.SC_BAD_REQUEST).log().all();
        } catch ( Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case:" +  e.getMessage());
        }
    }

    @Test
    public void verifyCreateSuccessful() {
        try {
            given()
                    .header("Content-Type", "application/json")
                    .body(userPersonalDetailsPayload)
                    .when()//.log().all()
                    .post(Resources.postUsersCreate())
                    .then().assertThat()
                    .statusCode(HttpStatus.SC_CREATED).log().all();
        } catch ( Exception e) {
            e.printStackTrace();
            Assert.fail("Exception thrown Test case:" +  e.getMessage());
        }
    }


}
