package common;

import org.openqa.selenium.By;

import constant.Constant;

public class EmailUtilities {
	public static By txtCheckEmailInbox = By.id("inboxfield");
	public static By btnGoEmailInbox = By.xpath("//button[@class='btn btn-dark']");
	public static By confirmEmailInbox = By.xpath("//div[@class='table-responsive']//tr[1]/td[4]");
	public static By activeLinkConfirmEmail = By.xpath("//a[contains(.,'confirmationCode')]");
	public static By resetLinkEmail = By.xpath("//a[contains(.,'PasswordReset')]");
	public static String iframeEmailId = "msg_body";
	
	public static String generateEmail() {
		String email = Constant.UserInfo.USERNAME_EMAIL + System.currentTimeMillis() + "@mailinator.com";
		System.out.println("email:::: " + email);
		return email;
	}
	
	public static void openActiveEmailLink(String email) {
		openEmail(email);
		Constant.WEBDRIVER.navigate().to(Utilities.waitForElement(activeLinkConfirmEmail).getText());
	}
	
	public static void openResetPasswordLink(String email) {
		openEmail(email);
		Constant.WEBDRIVER.navigate().to(Utilities.waitForElement(resetLinkEmail).getText());
	}
	
	public static void openEmail(String email) {
		Constant.WEBDRIVER.navigate().to(Constant.MAILINATOR_URL);
		ElementHelper.enterText(email, txtCheckEmailInbox);
		ElementHelper.clickElement(btnGoEmailInbox);
		Utilities.waitForElement(confirmEmailInbox).click();
		Constant.WEBDRIVER.switchTo().defaultContent();
		Constant.WEBDRIVER.switchTo().frame(iframeEmailId);
	}
	
}
