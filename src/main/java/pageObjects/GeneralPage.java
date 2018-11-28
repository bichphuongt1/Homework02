package pageObjects;

import org.openqa.selenium.By;
import common.ElementHelper;
import constant.Constant;
import constant.TabMenu;

public class GeneralPage{
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
	
	public String welcomeMsg = String.format(Constant.Message.LOGIN_WELCOME_MSG + "%s", Constant.UserInfo.USERNAME);
	
	public ElementHelper elementHelper = new ElementHelper();
	
	//methods
	public void gotoPage(TabMenu tab) {
		elementHelper.getTabElement(tab).click();
	}
	
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}
}
