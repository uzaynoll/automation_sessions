import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MerchantApplications {
    WebDriver driver;

    @FindBy(xpath = "//div[@class=\"MuiBox-root css-h3t4g5\"]")
    WebElement NewApplicationButton;


    @FindBy(xpath = "//td[@class=\"MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-7bu5d2\"]")
    List<WebElement> TableData;

    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary css-5860sp\"][1]")
    WebElement EnrolledMenuButton;

    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorPrimary css-5860sp\"][2]")
    WebElement ChangeRequestButton;


    public MerchantApplications(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
     public void clickNewApplicationButton(){
        NewApplicationButton.click();
     }

     public void clickEnrolledMenu(){
        EnrolledMenuButton.click();
     }

     public void clickChangeRequest(){
        ChangeRequestButton.click();
     }


     //need to write method to verify the Merchant Applications
}
