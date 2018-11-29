package Tests.login;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.ElementHelper;
import common.Utilities;
import constant.Constant;import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

public class LoginTest {
	
	LoginPage loginPage = new LoginPage();;
	HomePage homePage = new HomePage();
	ElementHelper elementHelper = new ElementHelper();
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditon");
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		assertEquals(homePage.getWelcomeMessage(), loginPage.getLoginWelcomeMessage(Constant.UserInfo.USERNAME));
	}

@Test(description = "TC02 - User can't login with blank \\\"Username\\\" textbox")
	public void TC02() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.BLANK, Constant.UserInfo.PASSWORD, 1);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_ERROR_MSG);
	}

@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, 1);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_ERROR_MSG);
	}
	
@Test(description = "TC04 - Login page displays when un-logged User clicks on \\\"Book ticket\\\" tab")
	public void TC04() {
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		assertEquals(homePage.getPageTitle(), Constant.PageTitle.LOGIN);
	}
	
@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, Constant.LIMITTED_TIMES);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_LOCKED_ERROR_MSG);
	}
	
@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
	
		Assert.assertTrue(elementHelper.isTabDisplayed(TabMenu.MY_TICKET));
		Assert.assertTrue(elementHelper.isTabDisplayed(TabMenu.CHANGE_PASSWORD));
		Assert.assertTrue(elementHelper.isTabDisplayed(TabMenu.LOGOUT));

		loginPage.gotoPage(TabMenu.MY_TICKET);
		assertEquals(loginPage.getPageTitle(), Constant.PageTitle.MY_TICKET);
		
		loginPage.gotoPage(TabMenu.CHANGE_PASSWORD);
		assertEquals(loginPage.getPageTitle(), Constant.PageTitle.CHANGE_PASSWORD);
		
		homePage.logout();
	}
	
	@Test(description = "TC08 - User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.gotoPage(TabMenu.REGISTER);
		RegisterPage registerPage = new RegisterPage();
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
		registerPage.gotoPage(TabMenu.LOGIN);
		loginPage.login(email, Constant.UserInfo.PASSWORD, 1);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_INVALID_ACCOUNT);		
		
		homePage.logout();
	}

}