package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredAdvanced {
    @Test
    public void RestAssuredAdvanced() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/store/order";
        Response response = given().accept(ContentType.JSON)
                .when().get("/{orderId}", 1999);

        JsonPath jsonPath=response.jsonPath();
        Map<String,Object> responseMap=jsonPath.getMap("$");
        System.out.println(responseMap.get("shipDate"));
        response.then().statusCode(200);

    }
    @Test
    public void getPet(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        Response response = given().accept(ContentType.JSON)
                .when().get("/{petId}", 101).then().statusCode(200).extract().response();

        JsonPath jsonPath=response.jsonPath();
        Map<String,Object> category=jsonPath.getMap("category");
        System.out.println(category.get("name"));

        List<Map<String, Object>>tags= jsonPath.getList("tags");
        System.out.println(tags.get(0).get("name"));
    }
    @Test
    public void getAllEmailsJsonPath(){
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api/users";
        Response response=given().accept(ContentType.JSON)
                .when().get().then().statusCode(200).extract().response();

                JsonPath jsonPath=response.jsonPath();
                List<Map<String,Object>>data=jsonPath.getList("data");
                data.forEach(f-> System.out.println(f.get("email"))); //lamda expression
//        for (int i=0;i<data.size();i++){
//            System.out.println(data.get(i).get("email"));
//        }

    }
}

