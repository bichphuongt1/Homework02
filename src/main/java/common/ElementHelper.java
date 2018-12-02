package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;
import constant.TabMenu;

public class ElementHelper {
	
	public static String tabName = "//span[normalize-space()='%s']";
	
	public static WebElement getTabElement(TabMenu tabMenu) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(tabName, tabMenu.getValue())));
	}
	
	public static void enterText(String str, By locator) {
		Constant.WEBDRIVER.findElement(locator).sendKeys(str);
	}
	
	public static void clearText(By locator) {
		Constant.WEBDRIVER.findElement(locator).clear();
	}
	
	public static void clickElement(By locator) {
		Constant.WEBDRIVER.findElement(locator).click();
	}
	
	public static String getTextElement(By locator) {
		return Constant.WEBDRIVER.findElement(locator).getText();
	}
	
	public static boolean isTabDisplayed(TabMenu tab) {
		try	{
			return getTabElement(tab).isDisplayed();
		} catch(Exception NoSuchElementException) {
			return false;
		}
	}
}
