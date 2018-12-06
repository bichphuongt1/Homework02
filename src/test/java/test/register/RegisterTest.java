package test.register;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.EmailUtilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import test.testbase.TestBase;


public class RegisterTest extends TestBase{
	
	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage();
	
	@Test(description = "TC07 - User can create new account'")
	public void TC07() {
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(EmailUtilities.generateEmail(), Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.NO_ACTIVE);
		assertEquals(registerPage.getRegisterSuccessMessage(), Constant.Message.REGISTER_SUCCESS_MSG);
	}
	
	@Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(EmailUtilities.generateEmail(), Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD + "1", Constant.NO_ACTIVE);
		assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MSG);
	}
	
	@Test(description = "TC11 - User can't create account while password and PID fields are empty")
	public void TC11() {
		SoftAssert softAssert = new SoftAssert();
			
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.register(EmailUtilities.generateEmail(), Constant.UserInfo.BLANK, Constant.UserInfo.BLANK, Constant.UserInfo.BLANK);
		softAssert.assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MSG);
		softAssert.assertEquals(registerPage.getPasswordErrorMessage(), Constant.Message.REGISTER_PASSWORD_INVALID_MSG);
		softAssert.assertEquals(registerPage.getPidErrorMessage(), Constant.Message.REGISTER_PID_INVALID_MSG);
	}
	
}
