package common;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import constant.Constant;

public class Utilities {
	
	public static Faker faker = new Faker();
	
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();		
	}
		
	public static String generateEmail() {
		String email = faker.internet().emailAddress();
		if(email.isEmpty()) {
			System.out.println("Error occured in generating email");
		}
		System.out.println("email:::: " + email);
		return email;
	}

	public static void openFakeEmailPage() {
		Constant.WEBDRIVER.navigate().to(Constant.FAKE_EMAIL_URL);
	}
	
	public static void openNewTabChrome() {
		Constant.WEBDRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	}
	
	public static void switchToTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList<String> (Constant.WEBDRIVER.getWindowHandles());
		if (tabNumber < tabs.size()) {
			Constant.WEBDRIVER.switchTo().window(tabs.get(tabNumber));
		} else {
			System.out.println("Out of range tab list");
		}
	}
	
	public static void sleep(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		}
			catch(InterruptedException ie){
		}
	}
}
