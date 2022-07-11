package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SigninPage {
    public SigninPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

//    @FindBy(id = "signin_username")
 //   public WebElement usernameBox;



    @FindBy(xpath = "//input[@id='signin_username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox2;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "signin_submit")
    public WebElement loginButton;

    @FindBy(className = "alert alert-danger")
    public WebElement invalidUsernamePasswordText;

    @FindBy(id = "footer-grant")
    public WebElement acceptCookieButton;
}
