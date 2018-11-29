package test.Password;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ChangePasswordTest extends ChangePasswordPage {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
//		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC09 - User can change password.")
	public void TC09() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME_02, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.CHANGE_PASSWORD);
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();
		changePasswordPage.changePassword(Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD +"1", Constant.UserInfo.PASSWORD +"1");
		assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), Constant.Message.CHANGE_PASSWORD_SUCCESS_MSG);
	}
}
