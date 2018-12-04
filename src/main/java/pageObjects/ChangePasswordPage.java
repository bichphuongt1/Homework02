package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;
import constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	public static By txtCurrentPassword = By.id("currentPassword");
	public static By txtNewPassword = By.id("newPassword");
	public static By txtNewConfirmPassword = By.id("confirmPassword");
	public static By btnChangePassword = By.xpath("//input[@value='Change Password']");
	public static By lblMessage = By.xpath("//p[@class='message success']");
	
	public void changePassword(String currentPassword, String newPassword, String newConfirmPassword) {
		ElementHelper.enterText(currentPassword, txtCurrentPassword);
		ElementHelper.enterText(newPassword, txtNewPassword);
		ElementHelper.enterText(newConfirmPassword, txtNewConfirmPassword);
		ElementHelper.clickElement(btnChangePassword);
	}
	
	public String getChangePasswordSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblMessage).getText();
	}
	
	
}
