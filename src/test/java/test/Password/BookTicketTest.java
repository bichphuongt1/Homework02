package test.Password;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Utilities;
import constant.Constant;
import constant.TabMenu;
import pageObjects.BookTicketPage;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BookTicketTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	
	@BeforeClass
	public void beforeClass() {
		Utilities.openChromeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "TC14 - User can book 1 ticket at a time.")
	public void TC14() {
		
		homePage.gotoPage(TabMenu.LOGIN);
		
		loginPage.login(Constant.UserInfo.USERNAME, Constant.UserInfo.PASSWORD, 1);
		homePage.gotoPage(TabMenu.BOOK_TICKET);
		
		bookTicketPage.setDepartDate(Constant.BookTicket.DEPART_DATE);
		bookTicketPage.setDepartStation(Constant.BookTicket.DEPART_STATION);
		bookTicketPage.setArriveStation(Constant.BookTicket.ARRIVE_STATION);
		bookTicketPage.setSeatType(Constant.BookTicket.SEAT_TYPE);
		bookTicketPage.setTicketAmount(Constant.BookTicket.TICKET_AMOUNT);
		bookTicketPage.bookTicket();
		
		assertEquals(bookTicketPage.getBookTicketSuccessMessage(), Constant.Message.BOOK_TICKET_SUCCESS_MSG);
	}
}
