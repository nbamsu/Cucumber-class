package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredTypeRefIntro {

    //new TypeReference
    @Before
    public void setUp(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="api/users";
    }
    @Test
    public void typeReference(){
        Response response=given().accept(ContentType.JSON)
                .when().log().all().get("/7");
        Map<String, Object> map= response.getBody().as(new TypeRef<Map<String, Object>>() {
        });
        System.out.println(map.get("data"));
        Map<String,Object> userDetails=(Map<String,Object>)map.get("data");
        Assert.assertEquals("Email is invalid : ","michael.lawson@reqres.in",userDetails.get("email"));

    }
    @Test
    public void getAllQuotes(){
        Response response=given().accept(ContentType.JSON)
                .when().get("https://www.breakingbadapi.com/api/quotes");
        response.then().assertThat().statusCode(200);
        List<Map<String,Object>> quotes=response.getBody().as(new TypeRef<List<Map<String,Object>>>() {});

        Assert.assertEquals("invalid number of quotes",70,quotes.size());

    }
}
