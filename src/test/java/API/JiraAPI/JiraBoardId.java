package API.JiraAPI;

import API.POJO.CommentPojo;
import API.POJO.JiraAPIPOJO;
import API.utils.PayloadUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static API.utils.Constants.SESSIONID;
import static io.restassured.RestAssured.given;

public class JiraBoardId {
    @Test
    public void verifydetails() throws IOException, URISyntaxException {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "rest/agile/1.0/board";
        Response response = given().accept(ContentType.JSON)
                .cookie(SESSIONID,PayloadUtil.generateCookie())
                .when().request(Method.GET).then().statusCode(200).extract().response();
        JiraAPIPOJO jiraAPIPOJO = response.getBody().as(JiraAPIPOJO.class);
        System.out.println(jiraAPIPOJO.getValues().get(0));
        Assert.assertEquals("Board size verification failure",jiraAPIPOJO.getTotal(),jiraAPIPOJO.getValues().size());
        Assert.assertTrue("Board name verification failure",jiraAPIPOJO.getValues().get(0).get("name").toString().startsWith("KOV"));
        Assert.assertEquals("Board type verification failure",jiraAPIPOJO.getValues().get(0).get("type"),"scrum");
       // Assert.assertEquals("Board id verification failure",jiraAPIPOJO.getValues().get(0).get("id"));


    }
    @Test
    public void sendCommend() throws IOException, URISyntaxException {
    RestAssured.baseURI="http://localhost:8080";
    RestAssured.basePath="rest/api/2/issue";
    String comment="Clean up yr room, you still as a pig";
    Response response=given().cookie(SESSIONID,PayloadUtil.generateCookie())
            .accept(ContentType.JSON).contentType(ContentType.JSON)
            .body(PayloadUtil.createComment(comment))
            .when().post("COVID19-1/comment").then().statusCode(201).extract().response();
    CommentPojo commentPojo=response.getBody().as(CommentPojo.class);
        Assert.assertEquals(comment, commentPojo.getBody());
    }

    /*
    {
  "issues": [
    "TEC-11"
  ]
}
     */
}
