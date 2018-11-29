package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;
import constant.TabMenu;

public class ElementHelper {
	
	public String tabName = "//span[normalize-space()='%s']";
	public WebElement getTabElement(TabMenu tabMenu) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName, tabMenu.getValue())));
	}
	

	public void enterText(String str, By locator) {
		Constant.WEBDRIVER.findElement(locator).sendKeys(str);
	}
	
	public void clickElement(By locator) {
		Constant.WEBDRIVER.findElement(locator).click();
	}
	
	public String getTextElement(By locator) {
		return Constant.WEBDRIVER.findElement(locator).getText();
	}
	
	public boolean isTabDisplayed(TabMenu tab) {
		try	{
			return getTabElement(tab).isDisplayed();
		} catch(Exception NoSuchElementException) {
			return false;
		}
	}
}
