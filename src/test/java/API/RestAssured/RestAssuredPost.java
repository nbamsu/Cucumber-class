package API.RestAssured;

import API.POJO.PetPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredPost {
    @Test
    public void createUser() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api/users";
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("name", "Tropikano");
        reqBody.put("job", "Boom");
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(reqBody)
                .when().post();
        response.then().statusCode(201).and()
                .body("name", Matchers.is("Tropikano"));


    }

    @Test
    public void createPet() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        File petBody = new File("pet.json");
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(petBody)
                .when().post();
        response.then().statusCode(200)
                .body("category.name", Matchers.is("poping"));
    }

    @Test
    public void createBody() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        String reqBody="{\n" +
                "  \"id\": 3333,\n" +
                "  \"category\": {\n" +
                "    \"id\": 7,\n" +
                "    \"name\": \"poping\"\n" +
                "  },\n" +
                "  \"name\": \"Dudu\",\n" +
                "  \"photoURl\": null,\n" +
                "  \"tags\": null,\n" +
                "  \"status\": \"home boy\"\n" +
                "}";
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(reqBody)
                .when().post();
        response.then().statusCode(200)
                .body("category.name",Matchers.is("poping"));
    }
    @Test
    public void createPet3(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        PetPojo petBody=new PetPojo();
        petBody.setId(123456789);
        petBody.setName("Crouch");
        petBody.setStatus("not available");

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(petBody)
                .when().post();
        response.then().statusCode(200).and().body("id",Matchers.is(123456789))
                .and().body("name",Matchers.is("Crouch"))
                .and().body("status",Matchers.is("not available"));
    }
}
