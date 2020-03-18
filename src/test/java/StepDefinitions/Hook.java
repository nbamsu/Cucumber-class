package StepDefinitions;

import Utils.BrowserUtils;
import Utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {

    WebDriver driver;
    //it will run before every scenario
    @Before
    public void setUpDriver(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      //  driver.manage().window().fullscreen();
        System.out.println("This is from Before annotation ");
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("This is After annotation");
        if (scenario.isFailed()){
            BrowserUtils.takeScreenShot();
        }
//        if (driver!=null){
//            driver.quit();
//            driver=null;
//        }

    }
}
