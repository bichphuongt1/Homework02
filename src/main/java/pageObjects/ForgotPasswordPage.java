package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;
import constant.Constant;

public class ForgotPasswordPage extends GeneralPage {
	private final By txtEmail = By.id("email");
	private final By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	
	public void requestResetPassword(String email) {
		ElementHelper.enterText(email, txtEmail);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
	}
}
