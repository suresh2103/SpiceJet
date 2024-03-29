package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.BookingPageValidation;
import page.components.LoginPage;

public class BookingPageValidationTest extends BaseEngine {

	// Test case to validate the Booking page
	@Test(priority = 1, groups = { "Regression" })
	public void checkinTc() throws Exception {

		test = report.createTest("Tc10-Validating option in Booking Page");

		// Login Function
		LoginPage validLogin = new LoginPage();

		validLogin.signinBooking(readingExcel("Signin", 1, 0), readingExcel("Signin", 1, 1));

		// validate the booking page
		BookingPageValidation bookingValidate = new BookingPageValidation();

		bookingValidate.bookingValidate();

		test.log(Status.PASS, "Validated");

	}

}