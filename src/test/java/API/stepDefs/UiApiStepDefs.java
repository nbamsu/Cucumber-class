package API.stepDefs;

import API.utils.Constants;
import API.utils.PayloadUtil;
import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import static API.utils.Constants.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class UiApiStepDefs {

    private WebDriver driver;

    Response response;
    private static String summary="Create as story from api from UI verification";
    @When("the user creates the story using api")
    public void the_user_creates_the_story_using_api() throws IOException, URISyntaxException {
        //http://localhost:8080/rest/api/2/issue

        RestAssured.baseURI="http://localhost:8080";
        RestAssured.basePath="rest/api/2/issue";
        String storyBody= PayloadUtil.getJiraIssuePayLoad(STORY,"tropikanoboom",
                "This is a story from JAVA","whats wrong",BUG,
                LOWEST_PRIORITY,"COVID19");
        response= given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .cookie(SESSIONID,PayloadUtil.generateCookie())
                .body(storyBody)
                .when().post();
    }
    @Then("verify story is created on the JiraBoard")
    public void verify_story_is_created_on_the_JiraBoard() throws IOException, URISyntaxException {
        driver=new ChromeDriver();
        driver.navigate().to("http://localhost:8080");
        Cookie JSESSIONID = new Cookie(Constants.SESSIONID,
                PayloadUtil.generateCookie());
        driver.manage().addCookie(JSESSIONID);
        driver.get("http://localhost:8080");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
        String issueKey=response.path("key");
        WebElement issue= driver.findElement(By.xpath("//a[.='"+issueKey+"']"));
        Assert.assertTrue(issue.getText().contains(issueKey));
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer expectedStatusCode) {
        //response.then().assertThat().statusCode(expectedStatusCode);
    }

}

