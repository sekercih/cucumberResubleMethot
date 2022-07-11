package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks
{
    // Cucumber'da feature ve stepdefinition eslesmesi class seviyesinde degil package seviyesindedir
    // dolayisiyla @Before ve @After stepdefinitions package'i altinda herhangi bir yerde olabilir
    // ancak uygulamada genellikle Hooks isminde bir class olusturup onun icine konulur
    @Before
    public void setUp(){}

    // eger senaryo failed olursa fotograf ceker
    // ancak burada close driver oldugu icin artik steplerimize close driver koymamaliyiz
    // yoksa sayfayi kapatip yeniden acar
    @After
    public void tearDown(Scenario scenario)
    {
        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed())
        {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }

}
