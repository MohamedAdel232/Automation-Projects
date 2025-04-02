package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static Steps.Hooks.*;
import static io.restassured.RestAssured.given;

public class StepsDefinitions {
    private static String boardId;
    private static JsonPath jsonPath;
    private static String responseBody;

    @Given("The request specification is set up with the board name")
    public void theRequestSpecificationIsSetUpWithTheBoardName() {
        requestSpecification = given()
                .log().all()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .queryParam("name", "My Board");
    }

    @When("POST request is sent to {string}")
    public void postRequestIsSent(String endpoint) {
        response = requestSpecification
                .when()
                .post(endpoint);
    }

    @Then("The response status code should be 200")
    public void theResponseStatusCodeShouldBe200() {
        responseBody = response.then()
                .log().all()
                .spec(responseSpecification)
                .extract().response()
                .asString();

        jsonPath = new JsonPath(responseBody);
        boardId = jsonPath.getString("id");

        Assert.assertEquals(200, response.getStatusCode());
    }

    @Given("The request specification is set up with the board ID")
    public void theRequestSpecificationIsSetUpWithTheBoardID() {
        requestSpecification = given()
                .spec(requestSpecification)
                .header("Content-Type", "application/json")
                .log().all();
    }

    @When("DELETE request is sent")
    public void deleteRequestIsSent() {
        response = requestSpecification
                .when()
                .delete("/boards/" + boardId);
    }

    @Given("The request specification is set up with the board ID and new name")
    public void theRequestSpecificationIsSetUpWithTheBoardIDAndNewName() {
        requestSpecification = given()
                .log().all()
                .spec(requestSpecification)
                .queryParam("name", "Updated Board Name");
    }

    @When("PUT request is sent")
    public void putRequestIsSent() {
        response = requestSpecification
                .when()
                .put("/boards/" + boardId);
    }

    @When("GET request is sent")
    public void getRequestIsSent() {
        response = requestSpecification
                .when()
                .get("/boards/" + boardId);
    }
}
