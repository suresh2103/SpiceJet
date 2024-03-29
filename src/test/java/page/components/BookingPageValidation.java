package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class BookingPageValidation extends WebUtilis {

	// WebElements
	@FindBy(xpath = "//div//div[text()='check-in']")
	WebElement checkIn;

	@FindBy(xpath = "//div[text()='flight status']")
	WebElement flightStatus;

	@FindBy(xpath = "//div[text()='manage booking']")
	WebElement manageBooking;

	// pagefactory intialization
	public BookingPageValidation() {

		PageFactory.initElements(driver, this);
	}

	// Method to validate the element is present or not
	public void bookingValidate() {

		// for checkin element
		String checkinActual = elementText(checkIn);
		Assert.assertEquals(checkinActual, "Check-In");

		// for flight status element
		String flightStatusActual = elementText(flightStatus);
		Assert.assertEquals(flightStatusActual, "Flight Status");

		// for manage booking element
		String bookingActual = elementText(manageBooking);
		Assert.assertEquals(bookingActual, "Manage Booking");

		screenshot("BookingValidate");
	}
}
