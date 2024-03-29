package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.FlightBookingPage;
import page.components.LoginPage;
import page.components.SearchFlightPage;

public class FlightBookingTest extends BaseEngine {

	// TestCase for validationg the booking page
	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void validPayTc01() throws Exception {

		test = report.createTest("Tc09- Booking Ticket");

		// Login function
		LoginPage validLogin = new LoginPage();

		validLogin.signinBooking(readingExcel("Signin", 1, 0), readingExcel("Signin", 1, 1));

		Thread.sleep(2000);
		// search for flight
		SearchFlightPage onewaySearch = new SearchFlightPage();

		onewaySearch.onewayFlight();

		Thread.sleep(2000);

		// Booking function
		FlightBookingPage booking = new FlightBookingPage();

		booking.bookingPayment(readingExcel("Ticket", 1, 0), readingExcel("Ticket", 1, 1), readingExcel("Ticket", 1, 2),
				readingExcel("Ticket", 1, 3), readingExcel("Ticket", 1, 4), readingExcel("Ticket", 1, 5),
				readingExcel("Ticket", 1, 6), readingExcel("Ticket", 1, 7), readingExcel("Ticket", 1, 8),
				readingExcel("Ticket", 1, 9), readingExcel("Ticket", 1, 10), readingExcel("Ticket", 1, 11));

		test.log(Status.PASS, "Ticket booking is Succesfull");
	}

}