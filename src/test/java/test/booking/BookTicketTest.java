package test.booking;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.Utilities;
import constant.ArriveStation;
import constant.Constant;
import constant.DepartStation;
import constant.SeatType;
import constant.TabMenu;
import constant.TicketInfo;
import pageObjects.BookTicketPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import test.testbase.TestBase;

public class BookTicketTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	SoftAssert softAssert = new SoftAssert();

	TicketInfo ticketInfo = new TicketInfo(Utilities.currentDatePlusDays(3), DepartStation.SAI_GON.getValue(), ArriveStation.NHA_TRANG.getValue(), SeatType.SOFT_BED_AIR_CONDITIONER.getValue(), 1);

	@Test(description = "TC14 - User can book 1 ticket at a time.")
	public void TC14() {
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		bookTicketPage.bookTicket(ticketInfo);
		softAssert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.Message.BOOK_TICKET_SUCCESS_MSG);
		softAssert.assertEquals(bookTicketPage.getTableDepartStation(), ticketInfo.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getTableArriveStation(), ticketInfo.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getTableSeatType(), ticketInfo.getSeatType());
		softAssert.assertEquals(bookTicketPage.getTableAmount(), String.valueOf(ticketInfo.getAmount()));
		softAssert.assertAll();
	}
}
