package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.LoginPage;
import page.components.SearchFlightPage;

public class SearchFlightTest extends BaseEngine {

	// Test case for one way trip flight search
	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void oneWayTc01() throws Exception {

		test = report.createTest("Tc07- Search for one way flight");

		// Login function
		LoginPage validLogin = new LoginPage();

		validLogin.signinBooking(readingExcel("Signin", 1, 0), readingExcel("Signin", 1, 1));

		Thread.sleep(2000);

		// search flight function
		SearchFlightPage onewaySearch = new SearchFlightPage();

		onewaySearch.onewayFlight();

		test.log(Status.PASS, "one way search is executed");
	}

	// Test case for round way trip flight search
	@Test(priority = 2, groups = { "Smoke", "Regression" })
	public void roundTripTc02() throws Exception {

		test = report.createTest("Tc08- Search for Round Trip flight");

		// Login function
		LoginPage validLogin = new LoginPage();

		validLogin.signinBooking(readingExcel("Signin", 1, 0), readingExcel("Signin", 1, 1));

		Thread.sleep(2000);

		// search flight function
		SearchFlightPage roundTrip = new SearchFlightPage();

		roundTrip.roundTripFlight();

		test.log(Status.PASS, "RoundTrip search is executed");
	}

}