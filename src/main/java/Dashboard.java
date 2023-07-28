import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dashboard {
    WebDriver driver;

    @FindBy(xpath = "//a[@class=\"MuiListItem-root MuiListItem-gutters MuiListItem-padding css-1bjtjtj\"]")
    List<WebElement> menuItems;
    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String findCurrentUrl() throws InterruptedException {
        Thread.sleep(5000);
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }

    public boolean checkMenuItems(String[] menu){
        int index = 0;
        for (WebElement menuItem: menuItems){
            if(menuItem.getText().equalsIgnoreCase(menu[index])){
                return true;
            }
            index++;
            }
        return false;
        }


    public void clickMenuItem(String menu){
        for (WebElement menuItem: menuItems){
            if(menuItem.getText().equalsIgnoreCase(menu)){
                menuItem.click();
                break;
            }
        }
    }
}
