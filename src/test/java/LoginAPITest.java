import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = TimesheetManagerApplication.class)
@ActiveProfiles("dev")
public class LoginAPITest {  //check a basic/MVP API call

    @Test
    public void testCheckLoginReturnsPositiveResult() {
        AuthPayload authPayload = new AuthPayload("admin@test.com", "password123");
        //call the AuthPayload class to create properly formatted JSON Object to be sent to API

        Response response = given()  //build and send HTTP request and store response
                .body(authPayload)  //place JSON object into Body
                .contentType("application/json") //set contant type header for API
                .post("http://localhost:8080/v1/auth/login"); //submit the post to this URL

        assertEquals(200, response.getStatusCode()); //confirm response is 200 = successful API call
    }
}
