package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import constant.Constant;

public class Utilities {
	
	public static By confirmEmailInbox = By.xpath("//div[@class='table-responsive']//tr[1]/td[4]");
	public static By activeLinkConfirmEmail = By.xpath("//a[contains(.,'confirmationCode')]");
	public static By resetLinkEmail = By.xpath("//a[contains(.,'PasswordReset')]");
	public static String iframeEmailId = "msg_body";
	
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static void openHomePage()
	{
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
	}
	
	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();		
	}
		
	public static String generateEmail() {
		String email = Constant.UserInfo.USERNAME_EMAIL + System.currentTimeMillis() + "@mailinator.com";
		System.out.println("email:::: " + email);
		return email;
	}
	
	public static void openActiveEmailLink(String email) {
		openEmail(email);
		Constant.WEBDRIVER.navigate().to(waitForElement(activeLinkConfirmEmail).getText());
	}
	
	public static void openResetPasswordLink(String email) {
		openEmail(email);
		Constant.WEBDRIVER.navigate().to(waitForElement(resetLinkEmail).getText());
	}
	
	public static void openEmail(String email) {
		Constant.WEBDRIVER.navigate().to(String.format(Constant.EMAIL_INBOX_URL, email.replaceAll("@mailinator.com", "")));
		waitForElement(confirmEmailInbox).click();
		Constant.WEBDRIVER.switchTo().defaultContent();
		Constant.WEBDRIVER.switchTo().frame(iframeEmailId);
	}
	
	public static WebElement waitForElement(By locator) {
	    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIMEOUT);
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
