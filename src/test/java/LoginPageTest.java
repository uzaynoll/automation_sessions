import Utils.ExcelUtils;
import Utils.Helper;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("BankPortal Login")
@Feature("Login")
public class LoginPageTest extends testSetup {
    @DataProvider(name = "Login Credentials")
    public Object[][] credentials() throws Exception {
//        Object[][] testObjArray = ExcelUtils.getExcelData("C://Users//ujjwa//OneDrive//Desktop//logindata.xlsx","Sheet1");
//        return testObjArray;
        return new Object[][]{
                {"ctznbnk","ujjwal.khanal@citytech.global","invalid"},
        };
    }
    @Test(dataProvider = "Login Credentials")
    @Description("Verify login")
    @Severity(SeverityLevel.CRITICAL)
    @Attachment(value = "Page screenshot", type = "image/png")
    public void testToVerifyCurrentUrlAfterLogin(String institutionId,String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        Helper helper = new Helper(driver);

        Boolean status = helper.verifyPageLoadingCompleted();
        System.out.println(status);

        loginPage.enterInstitutionId(institutionId);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.loginButton();
        String currentURL = dashboard.findCurrentUrl();
        String expectedURL = "https://getpay.finpos.global/qa/bank-portal/#/dashboard";

        helper.takeScreenshot();

        Assert.assertEquals(currentURL,expectedURL);
    }
}
