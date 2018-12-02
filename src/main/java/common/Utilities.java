package common;

import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import constant.Constant;

public class Utilities {
	
	public static Faker faker = new Faker();
	
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
		
	public static String generateFakeEmail() {
		String email = faker.internet().emailAddress();
		if(email.isEmpty()) {
			System.out.println("Error occured in generating email");
		}
		System.out.println("email:::: " + email);
		return email;
	}

	public static String generateEmail() {
		String email = Constant.UserInfo.USERNAME_EMAIL + System.currentTimeMillis() + "@mailinator.com";
		System.out.println("email:::: " + email);
		return email;
				
	}
	
	public static void openFakeEmailPage() {
		Constant.WEBDRIVER.navigate().to(Constant.FAKE_EMAIL_URL);
	}
	
}
