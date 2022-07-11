package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.Log;

import java.time.Duration;

public class ravenpackStepdefinition {
    AllPage allPage=new AllPage();
    @Given("User goes to ravenpack url mainpage")
    public void user_goes_to_ravenpack_url_mainpage() {
        Log.startTestCase("Raven Pack");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Log.info("User goes to ravenpack url mainpage");
    }
    @Then("User clicks to the Login button main page")
    public void user_clicks_to_the_login_button_main_page() {
        Driver.waitAndClick(allPage.homePage().acceptCookie);
        allPage.homePage().loginButton.click();
    }
    @Then("User sends invalid email address to email box")
    public void user_sends_invalid_email_address_to_email_box() {
    //    JSUtils.clickElementByJS(allPage.contactusPage().usernameBox);
    //    Driver.waitAndClick(allPage.contactusPage().usernameBox);
     //   Driver.waitAndClick(allPage.contactusPage().usernameBox2);
     //   Driver.getDriver().switchTo().frame("intercom-frame");
        allPage.contactusPage().usernameBox.sendKeys("123");
       Driver.waitAndSendText( allPage.contactusPage().usernameBox,Faker.instance().internet().emailAddress());
    }
    @Then("User sends invalid password address to password box")
    public void user_sends_invalid_password_address_to_password_box() {
        allPage.contactusPage().passwordBox.sendKeys(Faker.instance().internet().password());
    }
    @Then("User cliks to the Login button at signin page")
    public void user_cliks_to_the_login_button_at_signin_page() {
    allPage.contactusPage().loginButton.click();
    }
    @Then("User validates Invalid username or password. text displayed")
    public void user_validates_invalid_username_or_password_text_displayed() {
        Assert.assertTrue(allPage.contactusPage().invalidUsernamePasswordText.isDisplayed());
    }

    @And("User accepts cookies")
    public void userAcceptsCookies() throws InterruptedException {
       Driver.waitAndClick(allPage.contactusPage().acceptCookieButton);
    }

}
