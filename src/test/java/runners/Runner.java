package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"},
        features ="src/test/resources/features",
        glue = {"stepdefinitions","hooks"},

        tags = "@requestatrial",

        dryRun = false

)
public class Runner
{
    // Runner class'inin body'sine hicbir kod yazmayacagiz
    // Bu class icin onemli olan kullanacagimiz iki adet notasyon

    // dryRun=false : yazildiginda belirlenen tag'la etiketlenen tum scenario'lari sirasiyla calistirir
    // dryRun=true :  dedigimizde ise kodlari calistirmadan eksik step defination'lar olup olmadigini kontrol eder
    //                ve varsa bize eksik step defination'lari rapor eder, ve kodlari hic calistirmaz

    // features ve glue olarak spesific bir class veya feature dosyasini degil tum klasor ve package'i
    // sectik. Dolayisiyla stepdefinitions package'i icerisinde hangi class'da olursa olsun
    // isimize yarayan bir step definitions varsa rahatlikla kullanabiliriz
}
