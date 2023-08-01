import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnboardingProcess {
    WebDriver driver;
    @FindBy(name = "name")
    WebElement inputName;

    @FindBy(name = "businessName")
    WebElement inputBusinessName;

    @FindBy(id = "mui-component-select-businessType")
    WebElement ownershipTypeDropdown;

    @FindBy(xpath = "//*[@id=\"menu-businessType\"]/div[3]/ul/li")
    List<WebElement> ownershipTypes;

    @FindBy(name = "contactNumber")
    WebElement inputContactNumber;

    @FindBy(css = ".css-2r4c")
    WebElement saveAndContinue;

    @FindBy(css = ".css-1fjovvv")
    WebElement cancel;

    @FindBy(xpath = "//p[@class=\"MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained Mui-required css-v7esy\"]")
    List<WebElement> invalidInputErrorMessage;

    @FindBy(xpath = "//div[@id=\"snack\"]")
    List<WebElement> popupErrorMessage;

    @FindBy(xpath = "//label[@class=\"MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd css-1jaw3da\"]")
    List<WebElement> paymentAcceptingPointsCheckbox;

    public OnboardingProcess(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean invalidInputErrorCheck(){
        for (WebElement invalidInputError: invalidInputErrorMessage){
            if (invalidInputError.isDisplayed())
                return true;
        }
        return false;
    }

    public Boolean checkPopupErrorMessage(){
        for(WebElement popup: popupErrorMessage){
            if(popup.isDisplayed())
                return true;
        }
        return false;
    }
    public boolean verifyOwnershipTypes(String ownershipType[]) {
        int index = 0;
        for (WebElement ownership : ownershipTypes) {
            if (ownership.getText().equalsIgnoreCase(ownershipType[index])){
                return true;
            }
            index++;
        }
        return false;
    }
    public void fillUpGeneralInfo(String name, String businessName, String ownershipType, String contactNumber){
        inputName.sendKeys(name);
        inputBusinessName.sendKeys(businessName);
        ownershipTypeDropdown.click();

        for (WebElement ownership : ownershipTypes) {
            if (ownership.getText().equalsIgnoreCase(ownershipType)) {
                ownership.click();
            }
        }

        inputContactNumber.sendKeys(contactNumber);
        saveAndContinue.click();
    }

    public void paymentAcceptingPoints(String paymentAcceptingPointToCheck){
        for (WebElement paymentAcceptingPoint : paymentAcceptingPointsCheckbox){
            if(paymentAcceptingPoint.getText().equalsIgnoreCase(paymentAcceptingPointToCheck)){
                paymentAcceptingPoint.click();
            }
        }
    }
}
