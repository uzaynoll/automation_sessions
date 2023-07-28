package Example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;
import java.util.concurrent.TimeUnit;

public class login {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        testSetup();
        login();
        verifyLogin();
        driverClose();
    }
    public static void testSetup(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080)); //maximize()
    }

    public static void login() throws InterruptedException {
        driver.get("https://getpay.finpos.global/qa/bank-portal/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id(":r0:")).sendKeys("ctznbnk");
        driver.findElement(By.id(":r1:")).sendKeys("ujjwal.khanal@citytech.global");
        driver.findElement(By.id(":r2:")).sendKeys("Test@123");
        driver.findElement(By.cssSelector(".MuiButton-root")).click();
    }
    public static void verifyLogin() {
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();
        String actualURL = "https://getpay.finpos.global/qa/#/dashboard/";
        assert currentURL == actualURL : "Assertion Failed: Invalid Login";
    }

    public static void driverClose() {
        driver.quit();
    }

}
