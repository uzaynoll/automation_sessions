import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = ":r0:")
    WebElement elementInstitutionId;

    @FindBy(id = ":r1:")
    WebElement elementUsername;

    @FindBy(id = ":r2:")
    WebElement elementPassword;

    @FindBy(css = ".css-fuxpcq")
    WebElement elementLoginButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver =  driver;
    }

    public void enterInstitutionId(String institutionId) {
        elementInstitutionId.sendKeys(institutionId);
    }

    public void enterUsername(String username) {
        elementUsername.sendKeys(username);
    }

    public void enterPassword(String password){
        elementPassword.sendKeys(password);
    }

    public void loginButton(){
        elementLoginButton.click();
    }
}
