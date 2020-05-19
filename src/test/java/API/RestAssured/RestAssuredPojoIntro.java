package API.RestAssured;

import API.POJO.PetPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredPojoIntro {

    @Test
    public void getPet() {
        Response response = given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/101");
        response.then().statusCode(200);
        PetPojo petPojo = response.getBody().as(PetPojo.class);
        Assert.assertEquals(1, petPojo.getId());

    }
    @Test
    public void getCatFact(){
        Response response=given().accept(ContentType.JSON)
                .when().get("https://cat-fact.herokuapp.com/facts");
        response.then().statusCode(200);

    }
}
