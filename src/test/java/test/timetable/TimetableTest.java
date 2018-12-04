package test.timetable;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.ArriveStation;
import constant.Constant;
import constant.DepartStation;
import constant.TabMenu;
import pageObjects.BookTicketPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TimetablePage;
import test.testbase.TestBase;

public class TimetableTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	TimetablePage timetablePage = new TimetablePage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	SoftAssert softAssert = new SoftAssert();

	@Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
	public void TC15() {
		
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.TIMETABLE);
		
		String departStation = DepartStation.HUE.getValue();
		String arriveStation = ArriveStation.SAI_GON.getValue();
		timetablePage.goToBookTicket(departStation, arriveStation);
		softAssert.assertEquals(bookTicketPage.getPageName(), Constant.PageName.BOOK_TICKET);
		softAssert.assertEquals(bookTicketPage.getDepartStationSelectedOption(), departStation);
		softAssert.assertEquals(bookTicketPage.getArriveStationSelectedOption(), arriveStation);
		softAssert.assertAll();
	}
}
