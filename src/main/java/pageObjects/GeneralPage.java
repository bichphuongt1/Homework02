package pageObjects;

import org.openqa.selenium.By;
import common.ElementHelper;
import constant.Constant;
import constant.TabMenu;

public class GeneralPage {
	// Locators	
	public final By lblPageName = By.xpath("//div[@id='content']/h1");
	public final By lblWelcomeMessage = By.xpath("//div[@class='account']");
//	public final By lblErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	
	//methods
	public void gotoPage(TabMenu tab) {
		ElementHelper.getTabElement(tab).click();
	}
	
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}
	
	public String getPageName() {
		return Constant.WEBDRIVER.findElement(lblPageName).getText();
	}
	
	public void logout() {
		if(ElementHelper.isTabDisplayed(TabMenu.LOGOUT)) {
			ElementHelper.getTabElement(TabMenu.LOGOUT).click();
		} 
	}
}
