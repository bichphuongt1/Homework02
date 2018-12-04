package test.booking;

import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.Utilities;
import constant.ArriveStation;
import constant.Constant;
import constant.DepartStation;
import constant.SeatType;
import constant.TabMenu;
import constant.TicketInfo;
import constant.Constant.FormatDate;
import pageObjects.BookTicketPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import test.testbase.TestBase;

public class BookTicketTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	SoftAssert softAssert = new SoftAssert();
	
	TicketInfo ticketInfo = new TicketInfo(Utilities.plusDays(3), DepartStation.SAI_GON.getValue(), ArriveStation.NHA_TRANG.getValue(), SeatType.SOFT_BED.getValue(), 1);

	@Test(description = "TC14 - User can book 1 ticket at a time.")
	public void TC14() {
		
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		bookTicketPage.bookTicket(ticketInfo);
		softAssert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.Message.BOOK_TICKET_SUCCESS_MSG);
		softAssert.assertEquals(bookTicketPage.getDepartStation(), ticketInfo.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getArriveStation(), ticketInfo.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getSeatType(), ticketInfo.getSeatType());
		softAssert.assertEquals(bookTicketPage.getAmount(), String.valueOf(ticketInfo.getAmount()));
		softAssert.assertAll();
	}
	
	@Test(description = "TC15 - User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
	public void TC15() {
		
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		bookTicketPage.bookTicket(ticketInfo);
		softAssert.assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.Message.BOOK_TICKET_SUCCESS_MSG);
		softAssert.assertEquals(bookTicketPage.getDepartStation(), ticketInfo.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getArriveStation(), ticketInfo.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getSeatType(), ticketInfo.getSeatType());
		softAssert.assertEquals(bookTicketPage.getAmount(), String.valueOf(ticketInfo.getAmount()));
		softAssert.assertAll();
	}
	
}
