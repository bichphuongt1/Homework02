package test.register;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Message;
import common.Utilities;
import constant.Constant;
import pageObjects.GeneralPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class RegisterTest extends GeneralPage {
	
	HomePage homePage;
	RegisterPage registerPage;
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
		homePage = new HomePage();
		homePage.open();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditon");
		homePage.gotoRegisterPage();
		registerPage = new RegisterPage();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
	}
	
	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "User can create new account'")
	public void TC07() {
		registerPage.register(Constant.EMAIL, Constant.PASSWORD, Constant.PID);
		String actualMsg = registerPage.getPageTitle();
		String expectedMsg = Message.REGISTER_THANK_YOU_MSG;
		// System.out.println("EMAIL:::::" + Constant.EMAIL);
		// System.out.println(actualMsg);
		// System.out.println(expectedMsg);
		boolean result = actualMsg.equals(expectedMsg);
		if (result == false && (registerPage.getErrorMessage().equals(Message.REGISTER_ERROR_MSG))) {
			System.out.println("======= Email existing =======");
		}
		Assert.assertTrue(result, "Register Account failed. Message should be::: " + expectedMsg);
	}
}
