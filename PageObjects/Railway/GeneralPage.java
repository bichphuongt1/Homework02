package Railway;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	// Locators
	private final By tabLogin = By.xpath("//span[normalize-space()='Login']");
	private final By tabLogout = By.xpath("//span[normalize-space()='Log out']");	
	private final By tabBookTicket = By.xpath("//span[normalize-space()='Book ticket']");
	
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	
	//methods
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}
	
	public void gotoPage(By tabElement) {
		Constant.WEBDRIVER.findElement(tabElement).click();
	}
	
	public void gotoLoginPage()
	{
		gotoPage(tabLogin);
	}
	
	public void logout() {
		Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	public void gotoLoginPageFromBookTicket() {
		Constant.WEBDRIVER.findElement(tabBookTicket).click();
	}
}
