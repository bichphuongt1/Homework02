package pageObjects;

import org.openqa.selenium.By;
import common.ElementHelper;
import constant.Constant;
import constant.TabMenu;

public class GeneralPage{
	// Locators	
	public final By lblPageTitle = By.xpath("//div[@id='content']/h1");
	public final By lblWelcomeMessage = By.xpath("//div[@class='account']");
//	public final By lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	
	public ElementHelper elementHelper = new ElementHelper();
	
	//methods
	public void gotoPage(TabMenu tab) {
		elementHelper.getTabElement(tab).click();
	}
	
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}
	
	public String getPageTitle() {
		return Constant.WEBDRIVER.findElement(lblPageTitle).getText();
	}
	
	public void logout() {
		if(elementHelper.isTabDisplayed(TabMenu.LOGOUT)) {
			elementHelper.getTabElement(TabMenu.LOGOUT).click();
		} 
	}
}
