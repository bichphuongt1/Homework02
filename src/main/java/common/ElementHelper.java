package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class ElementHelper {
	
	public WebElement getWebElement(By locator) {
		return Constant.WEBDRIVER.findElement(locator);
	}
	
	public void enterText(String str, By locator) {
		getWebElement(locator).sendKeys(str);
	}
	
	public void clickElement(By locator) {
		getWebElement(locator).click();
	}
	
	public String getTextElement(By locator) {
		return getWebElement(locator).getText();
	}
	
	public boolean isElementDisplay(By locator) {
		try	{
			WebElement webElement = getWebElement(locator);
			boolean isDisplay = webElement.isDisplayed();
			return isDisplay;
		} catch(Exception NoSuchElementException) {
			return false;
		}
		
	}
}
