package pageObjects;

import org.openqa.selenium.By;

import constant.Constant;

public class ResetPasswordPage {
	private final By txtEmail = By.id("copy");
	private final By activeLink = By.xpath("//body/a");
	private final By inbox = By.xpath("//tr[@class='message unread']/td[@class='message_cell unread']");	

	public String getEmail() {
		return Constant.WEBDRIVER.findElement(txtEmail).getText();
	}
	
	public void copy() {
		Constant.WEBDRIVER.findElement(txtEmail).click();
	}
	
	public void openEmail() {
		Constant.WEBDRIVER.findElement(inbox).click();
	}
	
	public void activeLink() {
		Constant.WEBDRIVER.switchTo().frame(2);
		Constant.WEBDRIVER.findElement(activeLink).click();
	}
}
