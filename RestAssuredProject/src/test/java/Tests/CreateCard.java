package Tests;

import PojoClasses.CreateCardPojo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static Tests.CreateList.createListPojo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class CreateCard {
    public static CreateCardPojo createCardPojo;

    @Test(priority = 3)
    public void createCard() {
        String listId = createListPojo.getId();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1/")
                .addQueryParam("token", "ATTAcc51c5ad1811dc614180c578386b8380913914a412950160e8c759da29daccac7F26E2B0")
                .addQueryParam("key", "a171ed888954da4d06724034389a1904")
                .addQueryParam("idList", listId)
                .addQueryParam("name", "New Card")
                .setBody("")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();

        createCardPojo = given().log().all()
                .spec(requestSpecification)
                .when().post("cards")
                .then().log().all()
                .spec(responseSpecification)
                .extract().response().as(CreateCardPojo.class);
    }
}
