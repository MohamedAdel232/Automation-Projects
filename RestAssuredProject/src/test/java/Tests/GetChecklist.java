package Tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static Tests.CreateChecklist.createChecklistPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetChecklist {

    @Test(priority = 12)
    public void getChecklist() {
        String checklistId = createChecklistPojo.getId();
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/")
                .addQueryParam("token", "ATTAcc51c5ad1811dc614180c578386b8380913914a412950160e8c759da29daccac7F26E2B0")
                .addQueryParam("key", "a171ed888954da4d06724034389a1904")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();

        given().log().all()
                .spec(requestSpecification)
                .when()
                .get("checklists/" + checklistId)
                .then()
                .log().all()
                .spec(responseSpecification);
    }
}
