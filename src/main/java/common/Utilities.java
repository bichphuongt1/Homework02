package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;

public class Utilities {
	
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
		
	public static WebElement waitForElement(By locator) {
	    WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Constant.SHORT_TIMEOUT);
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static Date currentDatePlusDays(int numberDay) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(date);
		calendar.add(Calendar.DATE, numberDay);
		date = calendar.getTime();
		return date;
	}
	
	public static String dateToStringWithFormat(Date date, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
	}
	
	public static void acceptAlert() {
	    Alert alert = Constant.WEBDRIVER.switchTo().alert();
	    alert.accept();
	}
	
	public static int numberOfRowsInTable(By locator) {
		List<WebElement> rows = Constant.WEBDRIVER.findElements(locator);
		return rows.size();
	}
}
