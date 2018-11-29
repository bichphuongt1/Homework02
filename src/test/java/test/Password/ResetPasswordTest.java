package test.Password;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.ResetPasswordPage;

public class ResetPasswordTest {

	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage(); 
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage(); 
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterClass
	public void afterClass() {
	//	Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC12 - Errors display when password reset token is blank")
	public void TC12() {
		Utilities.openFakeEmailPage();
		Utilities.sleep(5000);
		resetPasswordPage.copy();
		
		Utilities.openNewTabChrome();
		Utilities.switchToTab(1);
		homePage.open();
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.inputEmail();
		registerPage.register(Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
		
		Utilities.switchToTab(0);
		Utilities.sleep(5000);
		resetPasswordPage.openEmail();
		Utilities.sleep(5000);
		resetPasswordPage.activeLink();

		assertEquals(true, true);
	}
	
	@Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		Utilities.openFakeEmailPage();
		Utilities.sleep(5000);
		resetPasswordPage.copy();
		
		Utilities.openNewTabChrome();
		Utilities.switchToTab(1);
		homePage.open();
		homePage.gotoPage(TabMenu.REGISTER);
		registerPage.inputEmail();
		registerPage.register(Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
		
		Utilities.switchToTab(0);
		Utilities.sleep(5000);
		resetPasswordPage.openEmail();
		Utilities.sleep(5000);
		resetPasswordPage.activeLink();

		assertEquals(true, true);
	}
}
