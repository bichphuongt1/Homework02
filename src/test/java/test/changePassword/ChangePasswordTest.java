package test.changePassword;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ChangePasswordTest extends ChangePasswordPage {
	public static LoginPage loginPage;
	public static HomePage homePage;
	
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
		gotoPage(tabLogin);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
	}

	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC09 - User can change password.")
	public void TC09() {
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		if(homePage.isElementDisplay(tabLogout) && homePage.isElementDisplay(tabChangePassword)) {
			clickElement(tabChangePassword);
			if(getTextElement(lblPageTitle).equals(Constant.PageTitle.CHANGE_PASSWORD)) {
				changePassword(Constant.UserInfo.PASSWORD, Constant.UserInfo.NEW_PASSWORD, Constant.UserInfo.NEW_PASSWORD);
				String actualMsg = getTextElement(lblMessage);
				String expectedMsg = Constant.Message.CHANGE_PASSWORD_SUCCESS_MSG;
				Assert.assertTrue(actualMsg.equals(expectedMsg), "Message should be::: " + expectedMsg);
			} else {
				System.out.println("Not Change Password page");
			}
		} else {
			System.out.println("Login failed. TC09 is blocked by TC01");
		}
	}
}
