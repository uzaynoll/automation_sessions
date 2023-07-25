import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "userId")
    WebElement elementuserID;

    @FindBy(id = "password")
    WebElement elementpassword;

    @FindBy(css = ".btn-custom-field")
    WebElement elementloginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver =  driver;
    }

    public void enterUsername(String username) {
        elementuserID.sendKeys(username);
    }

    public void enterPassword(String password) {
        elementpassword.sendKeys(password);
    }

    public void loginButton(){
        elementloginButton.click();
    }
}
