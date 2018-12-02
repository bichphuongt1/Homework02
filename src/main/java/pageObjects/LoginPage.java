package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;
import constant.Constant;

public class LoginPage extends GeneralPage {

	//Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	public final By lblLoginErrorMsg = By.xpath("//div[@id='content']/p[@class='message error LoginForm']");
	public final By lnkForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
	
	public ElementHelper elementHelper = new ElementHelper();
	
	public void login(String username, String password, int times)
	{
		if(!username.isEmpty())
		{
			elementHelper.enterText(username, txtUsername);
		}
		if(!password.isEmpty())
		{
			elementHelper.enterText(password, txtPassword);
		}
		for (int i = 0; i < times; i++) {
			elementHelper.clickElement(btnLogin);
		}	
	}
	
	public String getLoginWelcomeMessage(String username) {
		return Constant.Message.LOGIN_WELCOME_MSG + username; 
	}
	
	public String getLoginErrorMessage () {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();
	}
	
	public void openLink(By locator) {
		Constant.WEBDRIVER.findElement(locator).click();
	}
	
	public void openForgotPasswordLink() {
		openLink(lnkForgotPassword);
	}
}


