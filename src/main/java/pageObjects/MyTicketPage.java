package pageObjects;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import common.ElementHelper;
import common.Utilities;
import constant.Constant;
import constant.Constant.FormatDate;

public class MyTicketPage extends GeneralPage {
	public static String btnCancel = "//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/..//input[@value='Cancel']";
	public static By myTable = By.xpath("//table[@class='MyTable']/tbody/tr");
	
	public static By filterTableDepartStation = By.xpath("//select[@name='FilterDpStation']");
	public static By filterTableDepartDate = By.xpath("//input[@name='FilterDpDate']");
	public static By btnApplyFilter = By.xpath("//input[@value='Apply filter']");
	public static String txtFilterResult = "//td[normalize-space()='%s']";
	public static String tableFilterResult = "//table[@class='MyTable']/tbody/tr/td[normalize-space()='%s']";
	public static By lblErrorMessage = By.xpath("//div[@class='error message']");

	public void cancelTicket(String departStation, String arriveStation) {
		ElementHelper.clickElement(By.xpath(String.format(btnCancel, departStation, arriveStation)));
		Utilities.acceptAlert();
	}
	
	public int numberOfRowsInTicketTable() {
		return Utilities.numberOfRowsInTable(myTable);
	}
		
	public void filerByDepartStation(String departStation) {
		Select dropdown = new Select(Constant.WEBDRIVER.findElement(filterTableDepartStation));
		dropdown.selectByVisibleText(departStation);
		applyFilter();
	}
	
	public void filerByDepartDate(String departDate) {
		ElementHelper.enterText(departDate, filterTableDepartDate);
		applyFilter();
	}
	
	public void applyFilter() {
		ElementHelper.clickElement(btnApplyFilter);
	}
	
	public boolean isCorrectResult(String departStation) {
		return ElementHelper.isElementDisplayed(By.xpath(String.format(txtFilterResult, departStation)));
	}
	
	public int numberOfRowsInFilterResultTable(String departStation) {
		return Utilities.numberOfRowsInTable(By.xpath(String.format(tableFilterResult, departStation)));
	}
	
	public String getErrorMessageApplyFilter() {
		return ElementHelper.getTextElement(lblErrorMessage);
	}
}
