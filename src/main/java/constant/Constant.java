package constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
//	public static final String RAILWAY_URL = "http://192.168.189.206:8888";
	public static final String RAILWAY_URL = "https://1c5fcd6f.ngrok.io";
	public static final String USERNAME = "phuong.nguyen@logigear.com";
	public static final String PASSWORD = "123456789";
	public static final String INVALID_PASSWORD = "123";
	public static final String BLANK = "";
	public static final String PID = "87654321";
	
	//for register account
	public static final String PREFIX_EMAIL = "07";
	public static String EMAIL = "phuong.nguyen" + PREFIX_EMAIL + "@logigear.com";
}
