package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import common.ElementHelper;
import common.Utilities;
import constant.ArriveStation;
import constant.Constant;
import constant.DepartStation;
import constant.SeatType;
import constant.TabMenu;
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
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(departDate));
		dropdown.selectByVisibleText(departDateName);
	}
	
	public void selectDepartStation(String departStationName) {
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(departStation));
		dropdown.selectByVisibleText(departStationName);
	}
	
	public void selectArriveStation(String arriveStationName) {
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(arriveStation));
		dropdown.selectByVisibleText(arriveStationName);
	}
	
	public void selectSeatType(String seatTypeName) {
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(seatType));
		dropdown.selectByVisibleText(seatTypeName);
	}
	
	public void selectTicketAmount(int amount) {
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(ticketAmount));
		dropdown.selectByVisibleText(String.valueOf(amount));
	}
	
	public void bookTicket(TicketInfo ticketInfo) {
		Utilities.waitForElement(departDate);
		selectDepartDate(Utilities.dateToStringWithFormat(ticketInfo.getDepartDate(), FormatDate.FORMAT_STYLE));
		Utilities.waitForElement(departStation);
		selectDepartStation(ticketInfo.getDepartStation());
		Utilities.waitForElement(arriveStation);
		selectArriveStation(ticketInfo.getArriveStation());
		Utilities.waitForElement(seatType);
		selectSeatType(ticketInfo.getSeatType());
		Utilities.waitForElement(ticketAmount);
		selectTicketAmount(ticketInfo.getAmount());
		ElementHelper.clickElement(btnBookTicket);
	}
	
	public String getBookTicketSuccessMessage() {
		return Constant.WEBDRIVER.findElement(lblPageName).getText();
	}
	
	public String getTableDepartStation() {
		return ElementHelper.getTextElement(tableDepartStation);
	}
	
	public String getTableArriveStation() {
		return ElementHelper.getTextElement(tableArriveStation);
	}
	
	public String getTableSeatType() {
		return ElementHelper.getTextElement(tableSeatType);
	}
	
	public String getTableAmount() {
		return ElementHelper.getTextElement(tableAmount);
	}
	
	public String getSelectedOptionText(By locator) {
		Select select = new Select(Constant.WEBDRIVER.findElement(locator));
		WebElement selectedOption = select.getFirstSelectedOption();
		return selectedOption.getText();
	}
	
	public String getDepartStationSelectedOption() {	
		return getSelectedOptionText(departStation);
	}
	
	public String getArriveStationSelectedOption() {
		return getSelectedOptionText(arriveStation);
	}
	
	public void bookTickets(TicketInfo ticketInfo, int amount) {		
		if (amount <= DepartStation.values().length) {
			for (int i = 0; i < amount; i++) {
				TicketInfo newTicketInfo = new TicketInfo(ticketInfo.getDepartDate(), DepartStation.values()[i].getValue(), ticketInfo.getArriveStation(), ticketInfo.getSeatType(), ticketInfo.getAmount());
				if (newTicketInfo.getDepartStation().equals(newTicketInfo.getArriveStation())) {
					newTicketInfo.setArriveStation(ArriveStation.SAI_GON.getValue());
				}
				bookTicket(newTicketInfo);
				gotoPage(TabMenu.BOOK_TICKET);
			}
		}
	}
	
}
