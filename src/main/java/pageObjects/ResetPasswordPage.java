package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;
import constant.Constant;

public class ResetPasswordPage extends GeneralPage {
	
	public final By lblPasswordChangeForm = By.xpath("//legend[normalize-space()='Password Change Form']");
	public final By txtNewPassword = By.id("newPassword");
	public final By txtConfirmPassword = By.id("confirmPassword");
	public final By txtResetToken = By.id("resetToken");
	public final By btnResetPassword = By.xpath("//input[@value='Reset Password']");
	public final By lblResetPasswordErrorMsg = By.xpath("//p[@class='message error']");
	public final By lblConfirmPasswordErrorMsg = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
	
	public String getPasswordChangeFormName() {
		return Constant.WEBDRIVER.findElement(lblPasswordChangeForm).getText();
	}
	
	public void resetPasswordWithoutToken() {
		ElementHelper.enterText(Constant.UserInfo.NEW_PASSWORD, txtNewPassword);
		ElementHelper.clearText(txtResetToken);
		ElementHelper.clickElement(btnResetPassword);
	}
	
	public void resetPassword(String newPassword, String confirmNewPassword) {
		ElementHelper.enterText(newPassword, txtNewPassword);
		ElementHelper.enterText(confirmNewPassword, txtConfirmPassword);
		ElementHelper.clickElement(btnResetPassword);
	}
	
	public String getResetPasswordErrorMessage() {
		return ElementHelper.getTextElement(lblResetPasswordErrorMsg);
	}
	
	public String getConfirmPasswordErrorMessage() {
		return ElementHelper.getTextElement(lblConfirmPasswordErrorMsg);
	}
	
}
