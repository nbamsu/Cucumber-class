package Pages.IceHRMPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguagePage {
    public LanguagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="tabLanguage")
    public WebElement languageButton;
    @FindBy(xpath = "//div[@id='tabPageLanguage']//tbody//tr//td[2]")
    public  List<WebElement>longNames;
    @FindBy(xpath = "//div[@id='tabPageLanguage']//tbody//tr//td[1]")
    public List<WebElement> shortNames;


    public Map<String, String> getQualificationInfo(List<WebElement>keys, List<WebElement>values){
        Map<String,String> allInfo=new HashMap<>();
        for (int i=0;i<keys.size();i++){
            allInfo.put(keys.get(i).getText(),values.get(i).getText());
        }
        return allInfo;
    }
}
