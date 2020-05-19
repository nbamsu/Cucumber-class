package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredIntro {
    @Before
    public void setUP(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="api/users";
    }

    @Test
    public void restAssuredGet() throws URISyntaxException {

//        URIBuilder uriBuilder=new URIBuilder();
//        uriBuilder.setScheme("https").setHost("reqres.in").setPath("api/json");
        given().accept(ContentType.JSON)
                .when().get("11")
                .then().statusCode(200).contentType(ContentType.JSON)
                .body("page",equalTo(2));

    }
    @Test
    public void restAssuredGetUser(){
        given().accept(ContentType.JSON)
                .when().get("11")
                .then().statusCode(200)
                .and().body("data.first_name", Matchers.equalTo("George")).log().body();

    }
    @Test
    public void restAssuredGetUser2(){

        given().accept(ContentType.JSON)
                .when().get("11")
                .then().statusCode(200)
                .and().body("ad.text",Matchers.notNullValue());
    }

    @Test
    public void  getAllUsers(){

        given().accept(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .and().body("data",Matchers.hasSize(6))
                .and().body("data[1].first_name",Matchers.equalTo("Janet"))
        .and().body("data[1].last_name",Matchers.equalTo("Weaver")).log().body();

    }
    @Test
    public void getAllUsers12(){

        Map<String, Object> bas=new HashMap<>();
        bas.put("per_page",12);
        bas.put("asdaasd","jhkqjh");
        bas.put("asdafdsd","jhewkjh");
        bas.put("asdfdasd","jhwekjh");
        bas.put("asdasdd","jhkdsjh");
        given().accept(ContentType.JSON)
                .params(bas)
                .when().get()
                .then().statusCode(200).body("data",Matchers.hasSize(12)).log().body();

    }
    @Test
    public void getUserResponse(){
       Response response= given().accept(ContentType.JSON)
                .when().get();
               response.then().statusCode(200).and()
                       .body("data",Matchers.hasSize(6));
    }

}
