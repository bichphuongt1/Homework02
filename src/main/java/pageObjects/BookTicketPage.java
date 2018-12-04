package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.ElementHelper;
import common.Utilities;
import constant.Constant;
import constant.Constant.FormatDate;
import constant.TicketInfo;

public class BookTicketPage extends GeneralPage {
	public static By departDate = By.name("Date");
	public static By departStation = By.name("DepartStation");
	public static By arriveStation = By.name("ArriveStation");
	public static By seatType = By.name("SeatType");
	public static By ticketAmount = By.name("TicketAmount");
	public static By btnBookTicket = By.xpath("//input[@value='Book ticket']");	
	
	public static By tableDepartStation = By.xpath("//table[@class='MyTable']//tr[2]/td[1]");
	public static By tableArriveStation = By.xpath("//table[@class='MyTable']//tr[2]/td[2]");
	public static By tableSeatType = By.xpath("//table[@class='MyTable']//tr[2]/td[3]");
	public static By tableAmount = By.xpath("//table[@class='MyTable']//tr[2]/td[7]");
			
			
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
	
	public void selectTicketAmount(int amount) {
		WebElement element = Constant.WEBDRIVER.findElement(ticketAmount);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(String.valueOf(amount));
	}
	
	public void bookTicket(TicketInfo ticketInfo) {
		selectDepartDate(Utilities.dateToStringWithFormat(ticketInfo.getDepartDate(), FormatDate.FORMAT_STYLE));
		selectDepartStation(ticketInfo.getDepartStation());
		selectArriveStation(ticketInfo.getArriveStation());
		selectSeatType(ticketInfo.getSeatType());
		selectTicketAmount(ticketInfo.getAmount());
		Constant.WEBDRIVER.findElement(btnBookTicket).click();
	}
	
	public String getBookTicketSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblPageName).getText();
	}
	
	public String getDepartStation() {
		return ElementHelper.getTextElement(tableDepartStation);
	}
	
	public String getArriveStation() {
		return ElementHelper.getTextElement(tableArriveStation);
	}
	
	public String getSeatType() {
		return ElementHelper.getTextElement(tableSeatType);
	}
	
	public String getAmount() {
		return ElementHelper.getTextElement(tableAmount);
	}
	
	public String getDepartStationSelectedOption() {
		Select select = new Select(Constant.WEBDRIVER.findElement(departStation));
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}
	
	public String getArriveStationSelectedOption() {
		Select select = new Select(Constant.WEBDRIVER.findElement(arriveStation));
		WebElement option = select.getFirstSelectedOption();
		return option.getText();
	}
}
