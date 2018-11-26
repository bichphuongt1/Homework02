package pageObjects;

import org.openqa.selenium.By;

import constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	public static By txtCurrentPassword = By.id("currentPassword");
	public static By txtNewPassword = By.id("newPassword");
	public static By txtNewConfirmPassword = By.id("confirmPassword");
	public static By btnChangePassword = By.xpath("//input[@value='Change Password']");
	public static By lblMessage = By.xpath("//p[@class='message success']");
	
	public void changePassword(String currentPassword, String newPassword, String newConfirmPassword) {
		enterText(currentPassword, txtCurrentPassword);
		enterText(newPassword, txtNewPassword);
		enterText(newConfirmPassword, txtNewConfirmPassword);
		clickElement(btnChangePassword);
	}
	
}
