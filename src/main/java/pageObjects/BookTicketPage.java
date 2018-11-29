package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constant.Constant;

public class BookTicketPage extends GeneralPage {
	public static By departDate = By.name("Date");
	public static By departStation = By.name("DepartStation");
	public static By arriveStation = By.name("ArriveStation");
	public static By seatType = By.name("SeatType");
	public static By ticketAmount = By.name("TicketAmount");
	public static By btnBookTicket = By.xpath("//input[@value='Book ticket']");

	public void selectDepartDate(String departDateName) {
		WebElement element = Constant.WEBDRIVER.findElement(departDate);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(departDateName);
	}
	
	public void selectDepartStation(String departStationName) {
		WebElement element = Constant.WEBDRIVER.findElement(departStation);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(departStationName);
	}
	
	public void selectArriveStation(String arriveStationName) {
		WebElement element = Constant.WEBDRIVER.findElement(arriveStation);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(arriveStationName);
	}
	
	public void selectSeatType(String seatTypeName) {
		WebElement element = Constant.WEBDRIVER.findElement(seatType);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(seatTypeName);
	}
	
	public void selectTicketAmount(String ticketAmountName) {
		WebElement element = Constant.WEBDRIVER.findElement(ticketAmount);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(ticketAmountName);
	}
	
	public void bookTicket() {
		Constant.WEBDRIVER.findElement(btnBookTicket).click();
	}
	
	public String getBookTicketSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblPageTitle).getText();
	}
}
