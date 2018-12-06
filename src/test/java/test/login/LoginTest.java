package test.login;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.ElementHelper;
import common.EmailUtilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import test.testbase.TestBase;

public class LoginTest extends TestBase {

	LoginPage loginPage = new LoginPage();;
	HomePage homePage = new HomePage();

	@Test(description = "TC01 - User can log into Railway with valid username and password")
	public void TC01() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);
		assertEquals(homePage.getWelcomeMessage(), loginPage.getLoginWelcomeMessage(Constant.UserInfo.USERNAME));
		homePage.logout();
	}

	@Test(description = "TC02 - User can't login with blank \\\"Username\\\" textbox")
	public void TC02() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.BLANK, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_ERROR_MSG);
	}

	@Test(description = "TC03 - User cannot log into Railway with invalid password")
	public void TC03() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, Constant.LOGIN_ONE_TIME);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_ERROR_MSG);
	}

	@Test(description = "TC04 - Login page displays when un-logged User clicks on \\\"Book ticket\\\" tab")
	public void TC04() {
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		assertEquals(homePage.getPageName(), Constant.PageName.LOGIN);
	}

	@Test(description = "TC05 - System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.INVALID_PASSWORD, Constant.LIMITTED_LOGIN_TIMES);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_LOCKED_ERROR_MSG);
	}

	@Test(description = "TC06 - Additional pages display once user logged in")
	public void TC06() {
		SoftAssert softAssert = new SoftAssert();
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);

		softAssert.assertTrue(ElementHelper.isTabDisplayed(TabMenu.MY_TICKET));
		softAssert.assertTrue(ElementHelper.isTabDisplayed(TabMenu.CHANGE_PASSWORD));
		softAssert.assertTrue(ElementHelper.isTabDisplayed(TabMenu.LOGOUT));

		loginPage.gotoPage(TabMenu.MY_TICKET);
		softAssert.assertEquals(loginPage.getPageName(), Constant.PageName.MY_TICKET);

		loginPage.gotoPage(TabMenu.CHANGE_PASSWORD);
		softAssert.assertEquals(loginPage.getPageName(), Constant.PageName.CHANGE_PASSWORD);

		homePage.logout();
		softAssert.assertAll();
	}

	@Test(description = "TC08 - User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.gotoPage(TabMenu.REGISTER);
		RegisterPage registerPage = new RegisterPage();
		String email = EmailUtilities.generateEmail();
		registerPage.register(email, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.NO_ACTIVE);
		registerPage.gotoPage(TabMenu.LOGIN);
		loginPage.login(email, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);
		assertEquals(loginPage.getLoginErrorMessage(), Constant.Message.LOGIN_INVALID_ACCOUNT);

		homePage.logout();
	}

}