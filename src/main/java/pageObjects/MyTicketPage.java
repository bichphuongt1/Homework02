package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;
import common.Utilities;

public class MyTicketPage extends GeneralPage {
	public static String btnCancel = "//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/..//input[@value='Cancel']";
	public static By myTable = By.xpath("//table[@class='MyTable']/tbody/tr");

	public void cancelTicket(String departStation, String arriveStation) {
		ElementHelper.clickElement(By.xpath(String.format(btnCancel, departStation, arriveStation)));
		Utilities.acceptAlert();
	}
	
	public int numberOfRowsInTicketTable() {
		return Utilities.numberOfRowsInTable(myTable);
	}
		
}
