package pageObjects;

import org.openqa.selenium.By;

public class TimetablePage extends GeneralPage {
	public static By tableDepartStation = By.xpath("//td[text()='Huế']/following-sibling::td[text()='Sài Gòn']/..//a[contains(@href, 'book')]");
	
}
