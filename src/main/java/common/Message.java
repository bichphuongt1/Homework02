package common;

import constant.Constant;

public class Message {
	public static String LOGIN_SUCCESS_MSG = "Welcome " + Constant.USERNAME;
	public static String LOGIN_ERROR_MSG = "There was a problem with your login and/or errors exist in your form.";
	public static String LOGIN_INVALID_MSG = "Invalid username or password. Please try again.";
	public static String LOGIN_LOCKED_ERROR_MSG = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	public static String REGISTER_THANK_YOU_MSG = "Thank you for registering your account";
	public static String REGISTER_ERROR_MSG = "This email address is already in use.";
}
