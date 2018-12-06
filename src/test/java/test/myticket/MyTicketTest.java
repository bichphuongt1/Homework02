package test.myticket;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

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
import pageObjects.MyTicketPage;
import test.testbase.TestBase;

public class MyTicketTest extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	MyTicketPage myTicket = new MyTicketPage();
	
	TicketInfo ticketInfo = new TicketInfo(Utilities.currentDatePlusDays(3), DepartStation.SAI_GON.getValue(), ArriveStation.NHA_TRANG.getValue(), SeatType.SOFT_BED.getValue(), 1);

	@Test(description = "TC16 - User can cancel a ticket.")
	public void TC16() {
		
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, Constant.LOGIN_ONE_TIME);
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		bookTicketPage.bookTicket(ticketInfo);
		
		homePage.gotoPage(TabMenu.MY_TICKET);
		int numberOfRowsInTableBeforeCancel = myTicket.numberOfRowsInTicketTable();
		myTicket.cancelTicket(ticketInfo.getDepartStation(), ticketInfo.getArriveStation());
		assertEquals(numberOfRowsInTableBeforeCancel - 1, myTicket.numberOfRowsInTicketTable());
		
	}
}
