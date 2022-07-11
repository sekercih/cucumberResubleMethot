package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login-container")
    public WebElement loginButton;

    @FindBy(id = "cookie-accept-button")
    public WebElement acceptCookie;

    @FindBy(id = "requestGlobalModal")
    public WebElement requestaTrial;

    @FindBy(id = "requestInputFullName")
    public WebElement fullnameBox;

    @FindBy(id = "trialInputEmail")
    public WebElement emailAdressBox;

//    @FindBy(xpath = "//input[@id='termsConditions']")
 //   public WebElement termsConditionsCheckBox;

    @FindBy(xpath = "//label[@for='termsConditions']")
    public WebElement termsConditionsCheckBox;

    @FindBy(id = "subscribeMarketing")
    public WebElement subscribeMarketingCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButtonRewuestaTrial;

    @FindBy(id = "trialInputOrigin")
    public WebElement howDidyouHearAboutUsDropdown;

    @FindBy(xpath = "//span[.='Thank you for your request!']")
    public WebElement succesfulSubmitText;



}
