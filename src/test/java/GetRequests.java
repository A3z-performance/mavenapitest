import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class GetRequests extends TestConfig {


//    @Test
//    public void verifySuccessResponse() {
//        try {
//            given()
//                    .when()
//                    .get(Resources.getUserPage2EndPointUri())
//                    .then()
//                    .assertThat().statusCode(HttpStatus.SC_OK).body("page", equalTo(2))
//                    .and().body("data", hasItems());
//            //.and().body();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
//        }
//    }
//
//
//    @Test
//    public void verifySchema() {
//        try {
//            given().log().all()
//                    .when().log().all()
//                    .get(Resources.getUser2EndPointUri())
//                    .then()
//                    .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userdataschema.json"))
//                    .and().statusCode(HttpStatus.SC_OK).log().all();
//            //.and().body();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
//        }
//    }
//
//
//    @Test
//    public void verifyRespData() {
//        try{
//            UserData userData = given()
//                    .when()
//                    .get(Resources.getUser2EndPointUri())
//                    .then()
//                    .assertThat()
//                    //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userdataschema.json")).and()
//                    .statusCode(HttpStatus.SC_OK).log().all().extract().body().as(UserData.class);
//            Assert.assertEquals(userData.getData().getId(), 2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void verifyListResource() {
        try{
            Response response = given()
                    .when()
                    .get(Resources.getListRes())
                    .then()
                    .assertThat().body("data.year", hasItem(2000))
                    .contentType(ContentType.JSON).log().all().extract().response();
            //Assert.assertEquals(userData.getData().getId(), 2);

            List<UserData> uData = response.jsonPath().getList("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUserNotFound() {
        try{
            given()
                    .when()
                    .get(Resources.getUserNotFound())
                    .then()
                    .assertThat()
                    //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/userdataschema.json")).and()
                    .statusCode(HttpStatus.SC_NOT_FOUND).log().all();
            //Assert.assertEquals(userData.getData().getId(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


























}
