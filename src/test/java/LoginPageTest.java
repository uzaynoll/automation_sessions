import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTest extends testSetup {
    @DataProvider(name = "Login Credentials")
    public Object[][] credentials() throws Exception {
        Object[][] testObjArray = ExcelUtils.getExcelData("C://Users//ujjwa//OneDrive//Desktop//logindata.xlsx","Sheet1");
        return testObjArray;
//        return new Object[][]{
//                {"ctznbnk","ujjwal.khanal@citytech.global","invalid"},
//                {"ctznbnk","invalid@citytech.global","invalid"},
//                {"ctznbnk","invalid@citytech.global","Test@123"},
//                {"ctznbnk","ujjwalkomail@yopmail.com","Test@123"},
//        };
    }
    @Test(dataProvider = "Login Credentials")
    public void testToVerifyCurrentUrlAfterLogin(String institutionId,String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        loginPage.enterInstitutionId(institutionId);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.loginButton();
        String currentURL = dashboard.findCurrentUrl();
        String expectedURL = "https://getpay.finpos.global/qa/bank-portal/#/dashboard";
        Assert.assertEquals(currentURL,expectedURL);
    }
}
