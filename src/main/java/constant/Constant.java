package constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static WebDriver WEBDRIVER_FAKE;
//	public static final String RAILWAY_URL = "http://192.168.189.206:8888";
	public static final String RAILWAY_URL = "http://localhost:8888";
	public static final String FAKE_EMAIL_URL = "https://mailto.space/";
	
	public static final int LIMITTED_TIMES = 4;
	
	//User informations
	public class UserInfo {
		public static final String USERNAME = "phuong.nguyen@logigear.com";
		public static final String USERNAME_02 = "ntbp.bich@gmail.com";
		public static final String INVALID_USERNAME = "phuong.nguyen@yahoo.com";
		public static final String PASSWORD = "123456789111";
		public static final String CONFIRM_PASSWORD = "12345";
		public static final String INVALID_PASSWORD = "123";
		public static final String BLANK = "";
		public static final String PID = "87654321";
		
		public static final String NEW_PASSWORD = "1234567891";
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
	}

	// Page title
	public class PageTitle {
		public static final String LOGIN = "Login page";
		public static final String MY_TICKET = "Manage ticket";
		public static final String CHANGE_PASSWORD = "Change password";
		public static final String REGISTER = "";
	}
	
	// Book ticket
		public class BookTicket {
			public static final String DEPART_DATE = "12/5/2018";
			public static final String DEPART_STATION = "Sài Gòn";
			public static final String ARRIVE_STATION = "Nha Trang";
			public static final String SEAT_TYPE = "Soft bed with air conditioner";
			public static final String TICKET_AMOUNT = "1";
		}
}




