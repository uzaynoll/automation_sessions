import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Dashboard {
    WebDriver driver;
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    public String findCurrentUrl() throws InterruptedException {
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }
}
