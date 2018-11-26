package test.register;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;
import pageObjects.HomePage;
import pageObjects.RegisterPage;


public class RegisterTest extends RegisterPage {
	
	HomePage homePage;
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
		homePage = new HomePage();
		homePage.open();
//		Utilities.openChromeBrowser();
//		FakeEmailPage.open();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditon");
		gotoPage(tabRegister);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
	}
	
	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}

	@Test(description = "TC07 - User can create new account'")
	public void TC07() {
		Utilities.registeredEmail = generateEmail();
		register(Utilities.registeredEmail, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
		String actualMsg = getTextElement(lblPageTitle);
		String expectedMsg = Constant.Message.REGISTER_SUCCESS_MSG;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Register Account failed. Message should be::: " + expectedMsg);
	}
	
	@Test(description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		register(generateEmail(), Constant.UserInfo.PASSWORD, Constant.UserInfo.CONFIRM_PASSWORD, Constant.UserInfo.PID);
		String actualMsg = getTextElement(lblRegisterErrorMsg);
		System.out.print("actualMsg: " +actualMsg);
		String expectedMsg = Constant.Message.REGISTER_ERROR_MSG;
		Assert.assertTrue(actualMsg.equals(expectedMsg), "Register Account failed. Message should be::: " + expectedMsg);
	}
	
	// phuong add TC11
/*	@Test(description = "Phuong add ==== TC11 - create an account-> activated -> login")
	public void TC11() {
		System.out.println("Fake emaisl is get from FAKE page::::" + FakeEmailPage.email);
		register(FakeEmailPage.email, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD, Constant.UserInfo.PID);
	}*/
}
