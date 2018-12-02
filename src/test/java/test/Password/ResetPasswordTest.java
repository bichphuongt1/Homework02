package test.password;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import pageObjects.ResetPasswordPage;
import test.testbase.TestBase;

public class ResetPasswordTest extends TestBase {

	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage(); 
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage(); 
	
	@Test(description = "TC12 - Errors display when password reset token is blank")
	public void TC12() {

	}
	
	@Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
	public void TC13() {

	}
}
