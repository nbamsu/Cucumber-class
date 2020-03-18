package Pages.IceHRMPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QualificationPage {
    public QualificationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//i[@class='fa fa-check-square']")
    public WebElement qualificationButton;
    @FindBy(id = "tabEducation")
    public WebElement educationButton;
    @FindBy(xpath = "//div[@id='tabPageEducation']//td[1]")
    public List<WebElement> personalInfoNames;
    @FindBy(xpath = "//div[@id='tabPageEducation']//td[2]")
    public List<WebElement> personalInfoValues;

      /*
        Create one method will take two parameter as a List of keys and values
        This method will return Map<K,V>
         */
      public Map<String, String> getQualificationInfo(List<WebElement>keys,List<WebElement>values){
          Map<String,String> allInfo=new HashMap<>();
          for (int i=0;i<keys.size();i++){
              allInfo.put(keys.get(i).getText(),values.get(i).getText());
          }
          return allInfo;
      }

}
