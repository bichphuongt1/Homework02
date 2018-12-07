package test.testbase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import common.Utilities;
import constant.Constant;
import pageObjects.HomePage;

public class TestBase {

	HomePage homePage = new HomePage();
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
		Utilities.openHomePage();
	}

	@AfterClass
	public void afterClass() {
	//	Constant.WEBDRIVER.quit();
	}
}
