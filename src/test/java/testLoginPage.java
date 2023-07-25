import org.testng.Assert;
import org.testng.annotations.Test;

public class testLoginPage extends testSetup {
    @Test
    public void testToVerifyCurrentUrlAfterLogin(){
        LoginPage loginPage = new LoginPage(driver);
        Dashboard dashboard = new Dashboard(driver);
        loginPage.enterUsername("QAINTERNTEST@YOPMAIL.COM");
        loginPage.enterPassword("TEST@123");
        loginPage.loginButton();
        String currentURL = dashboard.findCurrentUrl();
        String expectedURL = "https://qa.citytech.global/finpos/merchant-portal/#/dashboard";
        Assert.assertEquals(currentURL,expectedURL);
    }
}
