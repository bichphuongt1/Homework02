package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Message;
import Common.Utilities;
import Constant.Constant;

public class LoginTest {
	
	public HomePage homePage;
	public LoginPage loginPage;
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
		homePage = new HomePage();
		homePage.open();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditon");
		homePage.gotoLoginPage();
		loginPage = new LoginPage();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description="TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Message.LOGIN_SUCCESS;
		Assert.assertEquals(actualMsg, expectedMsg, "Message should be " + expectedMsg);
	//	homePage.logout();
	}

/*	@Test
	public void TC02() {
		System.out.println("TC02 - User can't login with blank \"Username\" textbox");
		HomePage homePage = new HomePage();
		homePage.open();
				
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.login("", Constant.PASSWORD);
		
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC03() {
		System.out.println("TC03 - User cannot log into Railway with invalid password");
		HomePage homePage = new HomePage();
		homePage.open();
				
		LoginPage loginPage = homePage.gotoLoginPage();
		loginPage.login(Constant.USERNAME, "123");
		
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
		
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");			
	}
	
	@Test
	public void TC04() {
		System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");
		HomePage homePage = new HomePage();
		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPageFromBookTicket();
		String actualMsg = loginPage.getLoginPageTitle();
		String expectedMsg = "Login page";
		Assert.assertEquals(actualMsg, expectedMsg, "The page is not displayed as expected");		
	}
	
	@Test
	public void TC05() {
		System.out.println("TC05 - System shows message when user enters wrong password several times");
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		for(int i = 0; i < 3; i++) {
			loginPage.login(Constant.USERNAME,"");
		}
		
		String actualMsg = loginPage.getLoginErrorMsg();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
			
	}*/
}

