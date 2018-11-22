package pageObjects;

import org.openqa.selenium.By;

import constant.Constant;

public class RegisterPage extends GeneralPage {

	//locators
	private final By txtEmail = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPID = By.id("pid");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	
	//methods
	public void register(String email, String password, String pid) {
		this.enterText(email, txtEmail);
		this.enterText(password, txtPassword);
		this.enterText(password, txtConfirmPassword);
		this.enterText(pid, txtPID);
		Constant.WEBDRIVER.findElement(btnRegister).click();
	}
	
}
