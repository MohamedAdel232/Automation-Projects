package Steps;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Hooks {
    private static final String trelloToken = System.getenv("TRELLO_TOKEN");
    private static final String trelloKey = System.getenv("TRELLO_KEY");
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;
    public static Response response;

    @Before
    public static void setup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1")
                .addQueryParam("key", trelloKey)
                .addQueryParam("token", trelloToken)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .build();
    }
}
