package Tests;

import PojoClasses.CreateListPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static Tests.CreateBoard.createBoardPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CreateList {
    public static CreateListPojo createListPojo;

    @Test(priority = 2, dependsOnMethods = "Tests.CreateBoard.createBoard")
    public void createList() {
        String boardId = createBoardPojo.getId();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/")
                .addQueryParam("token", "ATTAcc51c5ad1811dc614180c578386b8380913914a412950160e8c759da29daccac7F26E2B0")
                .addQueryParam("key", "a171ed888954da4d06724034389a1904")
                .addQueryParam("idBoard", boardId)
                .addQueryParam("name", "New List")
                .setBody("")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();

        createListPojo = given().log().all()
                .spec(requestSpecification)
                .when().post("lists")
                .then().log().all().spec(responseSpecification)
                .extract().response().as(CreateListPojo.class);

        System.out.println(new CreateListPojo().getId());
    }
}
