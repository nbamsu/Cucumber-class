package API.UiApi;

import API.utils.Constants;
import API.utils.PayloadUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class UICookieAuth {
    private WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.jsp");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void logInJira() {

        driver.findElement(By.id("login-form-username")).sendKeys("tropikanoboom");
        driver.findElement(By.id("login-form-password")).sendKeys("123456789asd");
        driver.findElement(By.id("login-form-submit")).click();
        Assert.assertEquals(driver.getTitle(),"System Dashboard - JIRA");
    }
    @Test
    public void jiraCookie() throws IOException, URISyntaxException {
        Cookie jsessionIdcookie=new Cookie(Constants.SESSIONID, PayloadUtil.generateCookie());
        driver.manage().addCookie(jsessionIdcookie);
        driver.get("http://localhost:8080");
        String storyText=driver.findElement(By.xpath("//a[.='COVID19-1']")).getText();
        Assert.assertEquals("COVID19-1",storyText);

    }

}
