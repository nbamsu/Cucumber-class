package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static WebDriver driver;
    private  Driver(){}
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case"chrome":
                    try {
                        String nodeURL = "http://3.86.238.209:5555/wd/hub";// http://3.86.238.209:5555
                        File file = new File("C:\\Users\\Administrator\\Downloads.exe");//chrome driver file location in EC2 machine
                        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
                        desiredCapabilities.setBrowserName("chrome");
                        desiredCapabilities.setPlatform(Platform.ANY);

                        driver= new RemoteWebDriver(new URL(nodeURL), desiredCapabilities);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
//                    WebDriverManager.chromedriver().setup();
//                    driver=new ChromeDriver();
                    break;
                case"FireFox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
            }
        }
        return driver;
    }






}
