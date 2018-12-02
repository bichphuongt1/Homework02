package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.github.javafaker.Faker;

import common.ElementHelper;
import common.Utilities;
import constant.Constant;

public class RegisterPage extends GeneralPage {

	//locators
	private final By txtEmail = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPID = By.id("pid");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	public final By lblRegisterErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	public final By lblConfirmPasswordMsg = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
	private final By lblPasswordErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
	private final By lblPidErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");
	
	Faker faker = new Faker();
	
	//methods		
	public void register(String email, String password, String confirmPassword, boolean active) {
		ElementHelper.enterText(email, txtEmail);
		ElementHelper.enterText(password, txtPassword);
		ElementHelper.enterText(confirmPassword, txtConfirmPassword);
		ElementHelper.enterText(Constant.UserInfo.PID, txtPID);
		ElementHelper.clickElement(btnRegister);
		if(active) {
			Utilities.openActiveEmailLink(email);
		}
	}
	
	public void register(String email, String password, String confirmPassword, String pid) {
		ElementHelper.enterText(email, txtEmail);
		ElementHelper.enterText(password, txtPassword);
		ElementHelper.enterText(confirmPassword, txtConfirmPassword);
		ElementHelper.enterText(pid, txtPID);
		ElementHelper.clickElement(btnRegister);
	}
	
	public String getRegisterSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblPageName).getText();
	}
	
	public String getRegisterErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblRegisterErrorMsg).getText();
	}
	
	public String getPasswordErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblPasswordErrorMsg).getText();
	}
	
	public String getPidErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblPidErrorMsg).getText();
	}
		

	
}
