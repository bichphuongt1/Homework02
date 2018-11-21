package common;

import org.openqa.selenium.chrome.ChromeDriver;

import constant.Constant;

public class Utilities {
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();		
	}

}
