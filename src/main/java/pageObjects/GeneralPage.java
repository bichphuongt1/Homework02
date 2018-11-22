package pageObjects;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class GeneralPage {
	// Locators
	private final By tabLogin = By.xpath("//span[normalize-space()='Login']");
	public final By tabLogout = By.xpath("//span[normalize-space()='Log out']");	
	private final By tabBookTicket = By.xpath("//span[normalize-space()='Book ticket']");
	public final By tabMyTicket = By.xpath("//span[normalize-space()='My ticket']");
	public final By tabChangePassword = By.xpath("//span[normalize-space()='Change password']");
	public final By tabRegister = By.xpath("//span[normalize-space()='Register']");
	
	private final By lblPageTitle = By.xpath("//div[@id='content']/h1");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	
	//methods
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}
	
	public void enterText(String str, By element) {
		Constant.WEBDRIVER.findElement(element).sendKeys(str);
	}
	
	public void gotoPage(By locator) {
		Constant.WEBDRIVER.findElement(locator).click();
	}
	
	public void gotoLoginPage()
	{
		gotoPage(tabLogin);
	}
	
	public void gotoBookTicketPage() {
		gotoPage(tabBookTicket);
	}
	
	public void gotoMyTicketPage() {
		gotoPage(tabMyTicket);
	}
	
	public void gotoChangePasswordPage() {
		gotoPage(tabChangePassword);
	}
	
	public void gotoRegisterPage() {
		gotoPage(tabRegister);
	}
	
	public void logout() {
		Constant.WEBDRIVER.findElement(tabLogout).click();
	}
	
	public boolean isVisibleTab(By locator) {
		if(Constant.WEBDRIVER.findElement(locator) != null) {
			return true;
		}
		return false;
	}
	
	public String getPageTitle() {
		return Constant.WEBDRIVER.findElement(lblPageTitle).getText();
	}
	
	public String getErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();	
	}
}
