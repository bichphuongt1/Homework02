package pageObjects;

import org.openqa.selenium.By;
import common.ElementHelper;

public class GeneralPage extends ElementHelper {
	// Locators
	public final By tabLogin = By.xpath("//span[normalize-space()='Login']");
	public final By tabLogout = By.xpath("//span[normalize-space()='Log out']");	
	public final By tabBookTicket = By.xpath("//span[normalize-space()='Book ticket']");
	public final By tabMyTicket = By.xpath("//span[normalize-space()='My ticket']");
	public final By tabChangePassword = By.xpath("//span[normalize-space()='Change password']");
	public final By tabRegister = By.xpath("//span[normalize-space()='Register']");
	
	public final By lblPageTitle = By.xpath("//div[@id='content']/h1");
	public final By lblWelcomeMessage = By.xpath("//div[@class='account']");
//	public final By lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	
	//methods
	public void gotoPage(By locator) {
		clickElement(locator);
	}
	
	public void logout() {
		if(isElementDisplay(tabLogout)) {
			clickElement(tabLogout);
		}
	}
}
