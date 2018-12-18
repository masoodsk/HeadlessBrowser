package testcases;

import org.testng.annotations.Test;

import PageObjects.FlightBooking;
import PageObjects.HotelBooking;
import PageObjects.SignIn;
import testBase.testBase;
import utility.WaitForduration;

public class SuiteTestCases extends testBase {

	public SuiteTestCases() {
		super();
	}

	SignIn loginPage;
	FlightBooking objFlight;
	HotelBooking objBooking;

	@Test(priority = 1, enabled = false)
	public void testLoginToApplication() {
		loginPage = new SignIn(driver);
		loginPage.fn_ClickonYourTrips();
		WaitForduration.Waitfor(1000);
		loginPage.fn_signbutton();
		loginPage.fn_Close();
		WaitForduration.Waitfor(1000);
		loginPage.fn_flighClick();
	}

	@Test(priority = 2)

	public void oneWayFlightBook() {

		objFlight = new FlightBooking(driver);
		objFlight.oneWaySelection();
		objFlight.Journey("Banglore", "Hyderabad");
		objFlight.fn_clickoncalendar();
		String inputdates = "20/December/2018";

		objFlight.fn_Selectdates(inputdates);
		objFlight.fn_selAdults(2);
		objFlight.fn_selChildrens(2);
		objFlight.fn_selInfants(2);
		objFlight.fn_searchFlight();
		objFlight.fn_searchFlight();
		WaitForduration.Waitfor(50000);
		objFlight.fn_clickonHotelBooking();
	}

	@Test(priority=3)
	public void HotelBookingTest() {
		
		objBooking=new HotelBooking(driver);
		objBooking.fn_whereHotelInput("Hyderabad");
		String inputdates = "19/December/2018";

		objBooking.fn_Selectdates(inputdates);
		
	}
}
