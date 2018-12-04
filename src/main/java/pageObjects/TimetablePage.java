package pageObjects;

import org.openqa.selenium.By;

import common.Utilities;
import constant.Constant;

public class TimetablePage extends GeneralPage {
	public static String lnkBookTicket = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href, 'Book')]";

	public void goToBookTicket(String departStation, String arriveStation) {	
		Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkBookTicket, departStation, arriveStation))).click();
	}
}
