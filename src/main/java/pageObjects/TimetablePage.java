package pageObjects;

import org.openqa.selenium.By;

import common.ElementHelper;

public class TimetablePage extends GeneralPage {
	
	public static String lnkBookTicket = "//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/..//a[contains(@href, 'Book')]";

	public void goToBookTicket(String departStation, String arriveStation) {	
		ElementHelper.clickElement(By.xpath(String.format(lnkBookTicket, departStation, arriveStation)));
	}
}
