package constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static WebDriver WEBDRIVER_FAKE;
	public static final String RAILWAY_URL = "http://localhost:8888";
	public static final String MAILINATOR_URL = "https://mailinator.com";
	
	public static final int LIMITTED_LOGIN_TIMES = 4;
	public static final int LOGIN_ONE_TIME = 1;
	public static final boolean ACTIVE = true;
	public static final boolean NO_ACTIVE = false;
	public static final int SHORT_TIMEOUT = 5;
	
	public class FormName {
		public static final String PASSWORD_CHANGE_FORM = "Password Change Form";
	}
	
	//User informations
	public class UserInfo {
		public static final String USERNAME = "phuong.nguyen@logigear.com";
		public static final String USERNAME_USING_CHANGE_PASSWORD = "ntbp.bich@gmail.com";
		public static final String INVALID_USERNAME = "phuong.nguyen@yahoo.com";
		public static final String PASSWORD = "123456789111";
		public static final String NEW_PASSWORD = "123456789";
		public static final String CONFIRM_PASSWORD = "12345";
		public static final String INVALID_PASSWORD = "123";
		public static final String BLANK = "";
		public static final String PID = "87654321";
		public static final String USERNAME_EMAIL = "p";
	}
	
	// Format date
	public class FormatDate {
		public static final String FORMAT_STYLE = "MM/d/yyyy";
	}
	
	// Error Message
	public class Message {
		public static final String LOGIN_WELCOME_MSG = "Welcome ";
		public static final String LOGIN_ERROR_MSG = "There was a problem with your login and/or errors exist in your form.";
		public static final String LOGIN_INVALID_MSG = "Invalid username or password. Please try again.";
		public static final String LOGIN_LOCKED_ERROR_MSG = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static final String LOGIN_INVALID_ACCOUNT = "Invalid username or password. Please try again.";
		
		public static final String REGISTER_SUCCESS_MSG = "Thank you for registering your account";
		public static final String REGISTER_EMAIL_EXISTED_MSG = "This email address is already in use.";
		public static final String REGISTER_CONFIRM_PASSWORD_MSG = "The two passwords do not match";
		public static final String REGISTER_ERROR_MSG = "There're errors in the form. Please correct the errors and try again.";
		public static final String REGISTER_PASSWORD_INVALID_MSG = "Invalid password length.";
		public static final String REGISTER_PID_INVALID_MSG = "Invalid ID length.";
		
		public static final String CHANGE_PASSWORD_SUCCESS_MSG = "Your password has been updated!";
		
		public static final String BOOK_TICKET_SUCCESS_MSG = "Ticket booked successfully!";
		
		public static final String RESET_PASSWORD_TOKEN_ERROR_MSG = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
		public static final String RESET_PASSWORD_ERROR_MSG = "Could not reset password. Please correct the errors and try again.";
		public static final String RESET_TOKEN_INVALID_MSG = "The password reset token is invalid.";
		public static final String RESET_CONFIRM_PASSWORD_ERROR_MSG = "The password confirmation did not match the new password.";
	}

	// Page title
	public class PageName {
		public static final String LOGIN = "Login page";
		public static final String MY_TICKET = "Manage ticket";
		public static final String CHANGE_PASSWORD = "Change password";
		public static final String REGISTER = "";
		public static final String BOOK_TICKET = "Book ticket";
	}
	
}




