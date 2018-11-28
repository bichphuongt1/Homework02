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
	
	public ElementHelper element = new ElementHelper();
	
	//Methods

	public void login(String username, String password, int times)
	{
		//Submit login credentials
		if(!username.isEmpty())
		{
			element.enterText(username, txtUsername);
		}
		if(!password.isEmpty())
		{
			element.enterText(password, txtPassword);
		}
		for (int i = 0; i < times; i++) {
			element.clickElement(btnLogin);
		}	
	}
	
	public String getWelcomeMessage(String username) {
		return Constant.Message.LOGIN_WELCOME_MSG + username; 
	}
	
}


