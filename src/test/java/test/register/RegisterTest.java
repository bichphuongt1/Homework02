package test.register;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.ElementHelper;
import common.Utilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.RegisterPage;


public class RegisterTest {
	
	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage();
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

	@Test(description = "TC07 - User can create new account'")
	public void TC07() {
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(Utilities.generateEmail(), Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
		assertEquals(registerPage.getRegisterSuccessMessage(), Constant.Message.REGISTER_SUCCESS_MSG);
	}
	
	@Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(Utilities.generateEmail(), Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD + "1", Constant.UserInfo.PID);
		assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MSG);
	}
	
	@Test(description = "TC11 - User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(Utilities.generateEmail(), Constant.UserInfo.BLANK, Constant.UserInfo.BLANK, Constant.UserInfo.BLANK);
		assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MSG);
		assertEquals(registerPage.getPasswordErrorMessage(), Constant.Message.REGISTER_PASSWORD_INVALID_MSG);
		assertEquals(registerPage.getPidErrorMessage(), Constant.Message.REGISTER_PID_INVALID_MSG);
	}
	
}
