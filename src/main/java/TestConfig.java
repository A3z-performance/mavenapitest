import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    protected String userDtaJson;
    protected String userPersonalDetailsPayload;
    protected String invalidUserData;
    Properties prop;

    @BeforeMethod
    public  void preCondition() throws IOException {

        // userDtaJson = new FileReader().readFile("resources/userdataschema.json");
         //userPersonalDetailsPayload = new FileReader().readFile("requests/userPersonalDetails.json");
        //invalidUserData = new FileReader().readFile("requests/invalidUser.json");

        FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");


        prop = new Properties();
        prop.load(fis);
        RestAssured.baseURI = prop.getProperty("HOST");
    }
}
