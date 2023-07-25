import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testSetup {
    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa.citytech.global/finpos/merchant-portal/#/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
