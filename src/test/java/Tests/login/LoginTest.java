package Tests.login;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
		homePage = new HomePage();
		loginPage = new LoginPage();
		homePage.open();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditon");
		homePage.gotoPage(TabMenu.LOGIN);
	}

	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		assertEquals(homePage.getWelcomeMessage(), homePage.welcomeMsg);
	}

/*	@Test(description = "TC02 - User can't login with blank \\\"Username\\\" textbox")
	public void TC02() {
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		String actualMsg = getTextElement(lblLoginErrorMsg);
		String expectedMsg = Constant.Message.LOGIN_ERROR_MSG;
		assertEquals(homePage., expected);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {			
		login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, 1);
		String actualMsg = getTextElement(lblLoginErrorMsg);
		String expectedMsg = Constant.Message.LOGIN_ERROR_MSG;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);		
	}
	
	@Test(description = "TC04 - Login page displays when un-logged User clicks on \\\"Book ticket\\\" tab")
	public void TC04() {
		gotoPage(tabBookTicket);
		String actualMsg = getTextElement(lblPageTitle);
		String expectedMsg = Constant.PageTitle.LOGIN;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);		
	}
	
	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, 4);
		String actualMsg = getTextElement(lblLoginErrorMsg);
		String expectedMsg = Constant.Message.LOGIN_LOCKED_ERROR_MSG;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);		
	}
	
	@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() {
		login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		boolean result = getTextElement(lblWelcomeMessage).equals(Constant.Message.LOGIN_SUCCESS_MSG);
		if(result) {
			System.out.println("Login Successfully");
			
			//verify "My ticket", "Change password" and "Logout" tabs are displayed.
			Assert.assertTrue(isElementDisplay(tabMyTicket), "My Ticket tab is NOT displayed.");
			Assert.assertTrue(isElementDisplay(tabChangePassword), "Change Password tab is NOT displayed.");
			Assert.assertTrue(isElementDisplay(tabLogout), "Log out tab is NOT displayed.");
			
			//verify click "My ticket" tab, user will be directed to My ticket page
			if(isElementDisplay(tabMyTicket)) {
				gotoPage(tabMyTicket);
				Assert.assertTrue(getTextElement(lblPageTitle).equals(Constant.PageTitle.MY_TICKET), "Page title should be::: " + Constant.PageTitle.MY_TICKET);
			} 
			
			//verify Click "Change password" tab, user will be directed to Change password page
			if(isElementDisplay(tabChangePassword)) {
				gotoPage(tabChangePassword);
				Assert.assertTrue(getTextElement(lblPageTitle).equals(Constant.PageTitle.CHANGE_PASSWORD), "Page title should be::: " + Constant.PageTitle.CHANGE_PASSWORD);
			} 
			logout();
		} else {
			Assert.assertTrue(result, "Login Failed. TC06 is BLOCKED by TC01");
		}
	}
	
	@Test(description = "TC08 - User can't login with an account hasn't been activated")
	public void TC08() {
		System.out.println("Utilities.registeredEmail::: " + Utilities.registeredEmail);
		login(Utilities.registeredEmail, Constant.UserInfo.PASSWORD, 1);
		String actualMsg = getTextElement(lblLoginErrorMsg);
		String expectedMsg = Constant.Message.LOGIN_INVALID_ACCOUNT;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);		
	}
	
	// phuong add TC11
	@Test(description = "Phuong add ==== TC11 - create an account-> activated -> login")")
	public void TC11() {
		FakeEmailPage.element.click();
		login(FakeEmailPage.email, Constant.UserInfo.PASSWORD, 1);
		String actualMsg = getTextElement(lblWelcomeMessage);
		String expectedMsg = Constant.Message.LOGIN_SUCCESS_MSG;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);		
	} */
}