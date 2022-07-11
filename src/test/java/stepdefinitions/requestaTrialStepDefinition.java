package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AllPage;
import utilities.Driver;
import utilities.Log;
import utilities.TestBaseRapor;

public class requestaTrialStepDefinition extends TestBaseRapor {
    AllPage allPage=new AllPage();

    @And("User validates that he has entered the home page")
    public void userValidatesThatHeHasEnteredTheHomePage() {
       // extentTest=extentReports.createTest("raven pack","User validates that he has entered the home page");
        Log.startTestCase("Raven Pack");
        String actualTitle="Technology and insights for data-driven companies | RavenPack";
        String expectedTitle= Driver.getDriver().getTitle();
        Assert.assertEquals("main page unavailable",actualTitle,expectedTitle);
        Log.info("User validates that he has entered the home page");
        extentTest.info("User validates that he has entered the home page");
    }

    @Then("User clicks to the request a Trial button")
    public void userClicksToTheRequestATrialButton() {
        allPage.homePage().requestaTrial.click();
        Log.info("User clicks to the request a Trial button");
        extentTest.info("User clicks to the request a Trial button");
    }

    @Then("User enters name to full name box")
    public void userEntersNameToFullNameBox() throws InterruptedException {
        Thread.sleep(3000);
    allPage.homePage().fullnameBox.sendKeys(Faker.instance().name().fullName());
        Log.info("User enters name to full name box");
    }

    @Then("User enters email to email box")
    public void userEntersEmailToEmailBox() throws InterruptedException {
        Thread.sleep(3000);
        String fakeMail=Faker.instance().internet().emailAddress();
    //    System.out.println("fakeMail = " + fakeMail);
        if(fakeMail.contains("gmail")||fakeMail.contains("yahoo")) {
            String companymail = fakeMail.substring(0, fakeMail.length() - 9) + "bigbosscompany" + fakeMail.substring(fakeMail.length() - 4);
     //       System.out.println("companymail = " + companymail);
            allPage.homePage().emailAdressBox.sendKeys(companymail);
        }
        else{
            String companymail = fakeMail.substring(0, fakeMail.length() - 10) + "bigbosscompany" + fakeMail.substring(fakeMail.length() - 4);
            System.out.println("companymail = " + companymail);
            allPage.homePage().emailAdressBox.sendKeys(companymail);
        }
        allPage.homePage().fullnameBox.click();
        Log.info("User enters email to email box");
    }
    @And("User selects how he heard about Raven Pack")
    public void userSelectsHowHeHeardAboutRavenPack() throws InterruptedException {
        Thread.sleep(3000);
        Select select=new Select(allPage.homePage().howDidyouHearAboutUsDropdown);
        int num=Faker.instance().random().nextInt(0,10);
        select.selectByIndex(num);
        Log.info("User selects how he heard about Raven Pack");
    }
    @And("User cliks terms and conditions checkbox")
    public void userCliksTermsAndConditionsCheckbox() throws InterruptedException {
        Thread.sleep(3000);
        Driver.waitAndClick(allPage.homePage().termsConditionsCheckBox);
        Log.info("User cliks terms and conditions checkbox");
    }

    @Then("User cliks keep me updated checkbox")
    public void userCliksKeepMeUpdatedCheckbox() {
        allPage.homePage().subscribeMarketingCheckBox.click();
        Log.info("User cliks keep me updated checkbox");
    }

    @Then("User cliks submit button")
    public void userCliksSubmitButton() {
        allPage.homePage().submitButtonRewuestaTrial.click();
        Log.info("User cliks submit button");
    }


    @Then("User verifies succesful submit message")
    public void userVerifiesSuccesfulSubmitMessage() {
        Assert.assertTrue(allPage.homePage().succesfulSubmitText.isDisplayed());
        Log.info("User verifies succesful submit message");
        Log.endTestCase("Raven Pack");
    }
}
