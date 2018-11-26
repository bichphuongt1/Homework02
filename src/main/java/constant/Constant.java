package constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static WebDriver WEBDRIVER_FAKE;
//	public static final String RAILWAY_URL = "http://192.168.189.206:8888";
	public static final String RAILWAY_URL = "http://localhost:8888";
	public static final String FAKE_EMAIL_URL = "https://generator.email/inbox7/";
	
	//for register account
	public static final String PREFIX_EMAIL = "07";
	public static String EMAIL = "phuong.nguyen" + PREFIX_EMAIL + "@logigear.com";
	
	//User informations
	public class UserInfo {
		public static final String USERNAME = "phuong.nguyen@logigear.com";
		public static final String INVALID_USERNAME = "phuong.nguyen@yahoo.com";
		public static final String PASSWORD = "1234567891";
		public static final String CONFIRM_PASSWORD = "12345";
		public static final String INVALID_PASSWORD = "123";
		public static final String BLANK = "";
		public static final String PID = "87654321";
		
		public static final String NEW_PASSWORD = "1234567891";
	}
	
	// Error Message
	public class Message {
		public static final String LOGIN_SUCCESS_MSG = "Welcome " + UserInfo.USERNAME;
		public static final String LOGIN_ERROR_MSG = "There was a problem with your login and/or errors exist in your form.";
		public static final String LOGIN_INVALID_MSG = "Invalid username or password. Please try again.";
		public static final String LOGIN_LOCKED_ERROR_MSG = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static final String LOGIN_INVALID_ACCOUNT = "Invalid username or password. Please try again.";
		
		public static final String REGISTER_SUCCESS_MSG = "Thank you for registering your account";
		public static final String REGISTER_EMAIL_EXISTED_MSG = "This email address is already in use.";
		public static final String REGISTER_CONFIRM_PASSWORD_MSG = "The two passwords do not match";
		public static final String REGISTER_ERROR_MSG = "There're errors in the form. Please correct the errors and try again.";
		
		public static final String CHANGE_PASSWORD_SUCCESS_MSG = "Your password has been updated";
	}

	// Page title
	public class PageTitle {
		public static final String LOGIN = "Login page";
		public static final String MY_TICKET = "Manage ticket";
		public static final String CHANGE_PASSWORD = "Change password";
		public static final String REGISTER = "";
	}
}




