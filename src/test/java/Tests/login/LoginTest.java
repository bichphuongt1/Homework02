package Tests.login;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Message;
import common.PageTitle;
import common.Utilities;
import constant.Constant;
import pageObjects.ChangePasswordPage;
import pageObjects.GeneralPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class LoginTest extends GeneralPage {

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
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
	}

	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1);
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Message.LOGIN_SUCCESS_MSG;
		boolean result = actualMsg.equals(expectedMsg);
		Assert.assertTrue(result, "Message should be::: " + expectedMsg);
		if(result) {
			homePage.logout();
		}
	}

	@Test(description = "TC02 - User can't login with blank \\\"Username\\\" textbox")
	public void TC02() {
		loginPage.login(Constant.BLANK, Constant.PASSWORD, 1);
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = Message.LOGIN_ERROR_MSG;
		Assert.assertEquals(actualMsg, expectedMsg, "Message should be::: " + expectedMsg);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {			
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 1);
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = Message.LOGIN_ERROR_MSG;
		Assert.assertEquals(actualMsg, expectedMsg, "Message should be::: " + expectedMsg);			
	}
	
	@Test(description = "TC04 - Login page displays when un-logged User clicks on \\\"Book ticket\\\" tab")
	public void TC04() {
		homePage.gotoBookTicketPage();
		String actualMsg = loginPage.getPageTitle();
		String expectedMsg = PageTitle.loginPageTitle;
		Assert.assertEquals(actualMsg, expectedMsg, "Message should be::: " + expectedMsg);		
	}
	
	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD, 4);
		String actualMsg = loginPage.getErrorMessage();
		String expectedMsg = Message.LOGIN_LOCKED_ERROR_MSG;
		Assert.assertEquals(actualMsg, expectedMsg,"Message should be::: " + expectedMsg);		
	}
	
	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD, 1);
		boolean result = loginPage.getWelcomeMessage().equals(Message.LOGIN_SUCCESS_MSG);
		if(result) {
			System.out.println("Login Successfully");
			boolean isVisibleTabMyTicket = this.isVisibleTab(homePage.tabMyTicket);
			boolean isVisibleTabChangePassword = this.isVisibleTab(homePage.tabChangePassword);
			boolean isVisibleTabLogout = this.isVisibleTab(homePage.tabLogout);
			
			//verify "My ticket", "Change password" and "Logout" tabs are displayed.
			Assert.assertTrue(isVisibleTabMyTicket, "My Ticket tab is NOT displayed.");
			Assert.assertTrue(isVisibleTabChangePassword, "Change Password tab is NOT displayed.");
			Assert.assertTrue(isVisibleTabLogout, "Log out tab is NOT displayed.");
			
			//verify click "My ticket" tab, user will be directed to My ticket page
			if(isVisibleTabMyTicket) {
				gotoMyTicketPage();
				MyTicketPage myTicket = new MyTicketPage();
				Assert.assertTrue(myTicket.getPageTitle().equals(PageTitle.myTicketPageTitle));
			} 
			
			//verify Click "Change password" tab, user will be directed to Change password page
			if(isVisibleTabChangePassword) {
				gotoChangePasswordPage();
				ChangePasswordPage changePasswordPage = new ChangePasswordPage();
				Assert.assertTrue(changePasswordPage.getPageTitle().equals(PageTitle.changePasswordPageTitle));
			}
			
			homePage.logout();
		} else {
			Assert.assertTrue(result, "Login Failed. TC06 is BLOCKED by TC01");
		}
	}
}