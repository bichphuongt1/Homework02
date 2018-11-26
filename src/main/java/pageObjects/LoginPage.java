package pageObjects;

import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {

	//Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	public final By lblLoginErrorMsg = By.xpath("//div[@id='content']/p[@class='message error LoginForm']");
	
	//Methods

	public void login(String username, String password, int times)
	{
		//Submit login credentials
		if(!username.equals(null))
		{
			this.enterText(username, txtUsername);
		}
		if(!password.equals(null))
		{
			this.enterText(password, txtPassword);
		}
		for (int i = 0; i < times; i++) {
			this.clickElement(btnLogin);
		}	
	}
}


