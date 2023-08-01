import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testSetup {
    WebDriver driver;
    @Parameters({"grid","browser","platform"})
    @BeforeMethod
    public void driverSetup(String grid, String browser, String platform) throws MalformedURLException {
        if (grid.equalsIgnoreCase("true")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/"), capabilities);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://getpay.finpos.global/qa/bank-portal/#/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }
}
