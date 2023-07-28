package Example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNG_Login {
    WebDriver driver;
    @BeforeSuite
    public void testSetup(){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.get("https://qa.citytech.global/finpos/merchant-portal/#/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loginToSystem(){
        driver.findElement(By.id("userId")).sendKeys("QAINTERNTEST@YOPMAIL.COM");
        driver.findElement(By.id("password")).sendKeys("TEST@123");
        driver.findElement(By.cssSelector(".btn-custom-field")).click();
    }
    @Test
    public void printPageTitle(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://qa.citytech.global/finpos/merchant-portal/#/dashboard";
        Assert.assertEquals(currentURL,expectedURL);
    }
}
