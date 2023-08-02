import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MerchantApplicationTest extends testSetup{
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void verifyDonutCharts(){

        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        MerchantApplications merchantApplications = new MerchantApplications(driver);
        loginPage.enterInstitutionId("ctznbnk");
        loginPage.enterUsername("ujjwal.khanal@citytech.global");
        loginPage.enterPassword("Test@123");
        loginPage.loginButton();
        dashboard.clickMenuItem("Merchants");
        merchantApplications.clickNewApplicationButton();
    }
}
