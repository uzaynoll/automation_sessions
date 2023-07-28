import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashboardTest extends testSetup{
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void testToVerifyMenuItems() {
        String[] actualMenuItems= {"Dashboard","Transactions","Merchants","Service Fees","Approval Work Flow","Identity & Access"};

        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        loginPage.enterInstitutionId("ctznbnk");
        loginPage.enterUsername("ujjwal.khanal@citytech.global");
        loginPage.enterPassword("Test@123");
        loginPage.loginButton();

        softAssert.assertTrue(dashboard.checkMenuItems(actualMenuItems));
        dashboard.clickMenuItem("Transactions");

    }
}
