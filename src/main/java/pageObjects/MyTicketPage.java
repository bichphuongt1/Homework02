package pageObjects;

import org.openqa.selenium.By;

import common.Utilities;
import constant.Constant;

public class MyTicketPage extends GeneralPage {
	public static String btnCancel = "//td[text()='%s']/following-sibling::td[text()='%s']/..//input[@value='Cancel']";
	public static By myTable = By.xpath("//table[@class='MyTable']/tbody/tr");

	public void cancelTicket(String departStation, String arriveStation) {
		Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel, departStation, arriveStation))).click();
		Utilities.acceptAlert();
	}
	
	public boolean existsElement(String departStation, String arriveStation) {
	    return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnCancel, departStation, arriveStation))).isDisplayed();
	}
	
	public int numberOfRowsInTable() {
		return Utilities.numberOfRowsInTable(myTable);
	}
}
