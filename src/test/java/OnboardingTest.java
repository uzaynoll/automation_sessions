import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OnboardingTest extends testSetup{
    SoftAssert softAssert = new SoftAssert();
    @DataProvider(name = "Onboarding Data")
    public Object[][] onboardingData() throws Exception {
//        Object[][] testObjArray = Utils.ExcelUtils.getExcelData("C://Users//ujjwa//OneDrive//Desktop//onboardingData.xlsx","Sheet1");
//        return testObjArray;
        return new Object[][]{
                {"Hari Bashyal","Hari Fancy Pasal","Partnership","9865465347","Point-Of-Sale Terminals (POS)"},
        };
    }

    @Test(dataProvider = "Onboarding Data")
    public void verifyOnboarding(String name, String businessName, String ownershipType, String contactNumber, String paymentAcceptingPoint){

        String[] ownershipTypes = {"Sole Proprietorship","Partnership","Private Limited","Public Limited","Government","Non Profit Organizations"};

        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        MerchantApplications merchantApplications = new MerchantApplications(driver);
        OnboardingProcess onboardingProcess = new OnboardingProcess(driver);

        loginPage.enterInstitutionId("ctznbnk");
        loginPage.enterUsername("ujjwalkomail@yopmail.com");
        loginPage.enterPassword("Test@123");
        loginPage.loginButton();

        dashboard.clickMenuItem("Merchants");

        merchantApplications.clickNewApplicationButton();

        softAssert.assertTrue(onboardingProcess.verifyOwnershipTypes(ownershipTypes),"Assertion Error : Ownership Type/s not found.");
        onboardingProcess.fillUpGeneralInfo(name,businessName,ownershipType,contactNumber);
        Assert.assertFalse(onboardingProcess.checkPopupErrorMessage(),"Error Encountered");
        Assert.assertFalse(onboardingProcess.invalidInputErrorCheck(),"The provided input is invalid. Please enter a valid input and try again.");
        onboardingProcess.paymentAcceptingPoints(paymentAcceptingPoint);
    }
}
