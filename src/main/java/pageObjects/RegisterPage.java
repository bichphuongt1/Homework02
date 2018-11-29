package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.github.javafaker.Faker;

import common.ElementHelper;
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
	public ElementHelper elementHelper = new ElementHelper();
	
	//methods
	public void register(String email, String password, String confirmPassword, String pid) {
		elementHelper.enterText(email, txtEmail);
		elementHelper.enterText(password, txtPassword);
		elementHelper.enterText(confirmPassword, txtConfirmPassword);
		elementHelper.enterText(pid, txtPID);
		elementHelper.clickElement(btnRegister);
	}
	
	public String getRegisterSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblPageTitle).getText();
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
	
	public void inputEmail() {
		Constant.WEBDRIVER.findElement(txtEmail).sendKeys(Keys.CONTROL + "v");
	}
	
	public void register(String password, String confirmPassword, String pid) {
		elementHelper.enterText(password, txtPassword);
		elementHelper.enterText(confirmPassword, txtConfirmPassword);
		elementHelper.enterText(pid, txtPID);
		elementHelper.clickElement(btnRegister);
	}
	
}
