package test.password;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.Utilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import pageObjects.ResetPasswordPage;
import pageObjects.ForgotPasswordPage;
import test.testbase.TestBase;

public class ForgotPasswordTest extends TestBase {

	HomePage homePage = new HomePage();
	RegisterPage registerPage = new RegisterPage(); 
	LoginPage loginPage = new LoginPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(); 
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test(description = "TC12 - Errors display when password reset token is blank")
	public void TC12() {
		homePage.gotoPage(TabMenu.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD,  Constant.ACTIVE);
		
		registerPage.gotoPage(TabMenu.LOGIN);
		loginPage.openForgotPasswordLink();
		forgotPasswordPage.requestResetPassword(email);
		Utilities.openResetPasswordLink(email);
		softAssert.assertEquals(resetPasswordPage.getPasswordChangeFormName(), Constant.FormName.PASSWORD_CHANGE_FORM);
		resetPasswordPage.resetPasswordWithoutToken();
		softAssert.assertEquals(resetPasswordPage.getResetPasswordErrorMessage(), Constant.Message.RESET_PASSWORD_TOKEN_ERROR_MSG);
		// Remaining case: Verify Reset token is invalid.
		softAssert.assertAll();
	}
	
	@Test(description = "TC13 - Errors display if password and confirm password don't match when resetting password")
	public void TC13() {
		homePage.gotoPage(TabMenu.REGISTER);
		String email = Utilities.generateEmail();
		registerPage.register(email, Constant.UserInfo.PASSWORD, Constant.UserInfo.PASSWORD,  Constant.ACTIVE);
		
		registerPage.gotoPage(TabMenu.LOGIN);
		loginPage.openForgotPasswordLink();
		forgotPasswordPage.requestResetPassword(email);
		Utilities.openResetPasswordLink(email);
		softAssert.assertEquals(resetPasswordPage.getPasswordChangeFormName(), Constant.FormName.PASSWORD_CHANGE_FORM);
		resetPasswordPage.resetPassword(Constant.UserInfo.NEW_PASSWORD, Constant.UserInfo.NEW_PASSWORD + "1");
		softAssert.assertEquals(resetPasswordPage.getResetPasswordErrorMessage(), Constant.Message.RESET_PASSWORD_ERROR_MSG);
		softAssert.assertEquals(resetPasswordPage.getConfirmPasswordErrorMessage(), Constant.Message.RESET_CONFIRM_PASSWORD_ERROR_MSG); 
		softAssert.assertAll();
	}
}
