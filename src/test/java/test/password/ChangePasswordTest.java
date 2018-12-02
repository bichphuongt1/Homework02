package test.password;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import constant.TabMenu;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import test.testbase.TestBase;

public class ChangePasswordTest extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	ChangePasswordPage changePasswordPage = new ChangePasswordPage();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(description = "TC09 - User can change password.")
	public void TC09() {
		homePage.gotoPage(TabMenu.LOGIN);
		loginPage.login(Constant.UserInfo.USERNAME_USING_CHANGE_PASSWORD, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.CHANGE_PASSWORD);
		changePasswordPage.changePassword(Constant.UserInfo.PASSWORD, Constant.UserInfo.NEW_PASSWORD, Constant.UserInfo.NEW_PASSWORD);
		assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), Constant.Message.CHANGE_PASSWORD_SUCCESS_MSG);
		softAssert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(), Constant.Message.CHANGE_PASSWORD_SUCCESS_MSG);
		changePasswordPage.changePassword(Constant.UserInfo.NEW_PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD);
		softAssert.assertAll();
	}
}
