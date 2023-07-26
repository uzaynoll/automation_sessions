import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class testSetup {
    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://getpay.finpos.global/qa/bank-portal/#/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
