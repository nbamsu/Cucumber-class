package API.JiraAPI;

import API.utils.PayloadUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static API.utils.Constants.*;
import static io.restassured.RestAssured.given;

public class JiraIntro {
   public static final String VALUE="E721DF27BABD9E44349E3D01F75A947F";

    @Test
    public void createStory() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "rest/api/2/issue";
        String storyBody = PayloadUtil.getJiraIssuePayLoad("COVID19","Tropikanoboom", "User Should able to type log in name",
                "Easy", BUG, MEDIUM_PRIORITY,"HttpSprint");

        Response response = given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .cookie(KEY_VALUE, VALUE)
                .body(storyBody)
                .when().post().then().statusCode(201).extract().response();


    }

    @Test
    public void createBug() {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "rest/api/2/issue";
        String bugBody = PayloadUtil.getJiraIssuePayLoad("COVID19","Tropikanoboom", "User should able to navigate to financial part",
                "When user logged in to his account, then user able to open financial department ", BUG, LOWEST_PRIORITY,"Training Purpose");

        Response response=given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .cookie(KEY_VALUE,VALUE)
                .when().post(bugBody).then().statusCode(201).extract().response();

    }
    /*
    1. Using java code:
with Apache HttpClient and RestAssured libraries:
create 5 stories, 5 bugs
with high, midium, low priorities
change the summary and description
2. Add a logic to generate a new cookie for every call
3. POST: http://localhost:8080/rest/agile/1.0/sprint
 Create a new sprint
{
  "name": "sprint name",
  "startDate": "2020-04-11T15:22:00.000+10:00",
  "endDate": "2020-04-25T15:22:00.000+10:00",
  "originBoardId": 1,
  "goal": "Sprintgoal"
}
     */


}
