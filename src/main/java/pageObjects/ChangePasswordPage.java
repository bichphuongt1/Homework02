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
	
	public ElementHelper elementHelper = new ElementHelper();
	
	public void changePassword(String currentPassword, String newPassword, String newConfirmPassword) {
		elementHelper.enterText(currentPassword, txtCurrentPassword);
		elementHelper.enterText(newPassword, txtNewPassword);
		elementHelper.enterText(newConfirmPassword, txtNewConfirmPassword);
		elementHelper.clickElement(btnChangePassword);
	}
	
	public String getChangePasswordSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblMessage).getText();
	}
	
	
}
