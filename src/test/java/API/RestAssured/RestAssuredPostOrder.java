package API.RestAssured;

import API.POJO.OrderPojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestAssuredPostOrder {
    @Test
    public void createPostOrder(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/store/order";
        OrderPojo orderPojo=new OrderPojo();
        orderPojo.setId(2112);
        orderPojo.setPetId(007);
        orderPojo.setComplete(true);
        orderPojo.setQuantity(15);
        orderPojo.setShipDate("2020-03-29T17:10:48.020Z");
        orderPojo.setStatus("available");
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(orderPojo)
                .when().request("POST");
        response.then().statusCode(200).and().body("petId", Matchers.is(007));
    }

    @Test
    public void createOrderPost(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/store/order";
        Map<String,Object> reqmap=new HashMap<>();
        reqmap.put("id",987);
        reqmap.put("petId",8008);
        reqmap.put("quantity",5);
        reqmap.put("shipDate","2020-05-29T17:10:48.020Z");
        reqmap.put("status","available");
        reqmap.put("complete", true);
        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .body(reqmap)
                .when().request("POST");
        response.then().statusCode(200)
                .and().body("petId",Matchers.is(8008));
    }
}
