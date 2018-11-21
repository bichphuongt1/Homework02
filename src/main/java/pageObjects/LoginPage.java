package pageObjects;

import org.openqa.selenium.By;

import constant.Constant;

public class LoginPage extends GeneralPage {

	//Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	
	//need move after writting other TC
	private final By lblLoginErrorMsg = By.xpath("//div[@id='content']/p");
	private final By lblLoginPageTitle = By.xpath("//div[@id='content']/h1");
	
	//Methods
	public void enter(String str, By element) {
		Constant.WEBDRIVER.findElement(element).sendKeys(str);
	}
	
	public void login(String username, String password, int times)
	{
		//Submit login credentials
	//	if(username.equals(null))
		{
			System.out.println("username is not null");
			enter(username,txtUsername);
		}
	//	if(password.equals(null))
		{
			System.out.println("password is not null");
			enter(password,txtPassword);
		}
		for (int i = 0; i < times; i++) {
			Constant.WEBDRIVER.findElement(btnLogin).click();
		}	
	}
		
	//need move after writting other TC
	public String getErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();	
	}
	
	public String getPageTitle() {
		return Constant.WEBDRIVER.findElement(lblLoginPageTitle).getText();
	}
}


