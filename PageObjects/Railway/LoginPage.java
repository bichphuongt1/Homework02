package Railway;

import org.openqa.selenium.By;
import Constant.Constant;

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
	
	public void login(String username, String password)
	{
		//Submit login credentials
		enter(username,txtUsername);
		enter(password, txtPassword);
		Constant.WEBDRIVER.findElement(btnLogin).click();
	}
		
	//need move after writting other TC
	public String getErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();	
	}
	
	public String getPageTitle() {
		return Constant.WEBDRIVER.findElement(lblLoginPageTitle).getText();
	}
}


