package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class FakeEmailPage extends GeneralPage {


	public static By txtEmail = By.id("email_ch_text");
	public static String email = Constant.WEBDRIVER_FAKE.findElement(txtEmail).getText();
	public static By txtActiveUrl = By.xpath("//div[@class='e7m mess_bodiyy']//a[@href]");
	public static WebElement element = Constant.WEBDRIVER_FAKE.findElement(txtActiveUrl);
	
	public static void open()
	{
		Constant.WEBDRIVER_FAKE.navigate().to(Constant.FAKE_EMAIL_URL);
	}
}
