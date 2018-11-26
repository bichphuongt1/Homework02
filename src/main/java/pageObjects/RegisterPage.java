package pageObjects;

import org.openqa.selenium.By;

import com.github.javafaker.Faker;

public class RegisterPage extends GeneralPage {

	//locators
	private final By txtEmail = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPID = By.id("pid");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	public final By lblRegisterErrorMsg = By.xpath("//div[@id='content']/p[@class='message error']");
	public final By lblConfirmPasswordMsg = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
	
	Faker faker = new Faker();
	
	//methods
	public void register(String email, String password, String confirmPassword, String pid) {
		this.enterText(email, txtEmail);
		this.enterText(password, txtPassword);
		this.enterText(confirmPassword, txtConfirmPassword);
		this.enterText(pid, txtPID);
		this.clickElement(btnRegister);
	}
	
	public String generateEmail() {

		String email = faker.internet().emailAddress();
		if(email.equals(null)) {
			System.out.println("Error occured in generating email");
		}
		System.out.println("email:::: " + 	email);
		return email;
	}
}
