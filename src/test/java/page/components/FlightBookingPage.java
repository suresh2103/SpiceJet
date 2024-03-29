package page.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class FlightBookingPage extends WebUtilis {

	// WebElements

	@FindBy(xpath = "(//div[@data-testid='spiceflex-flight-select-radio-button-1'])[2]")
	WebElement selectFlight;

	@FindBy(xpath = "//*[@data-testid='continue-search-page-cta']")
	WebElement conFlightIcon;

	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement city;

	@FindBy(xpath = "//div[contains(text(),'WhatsApp or e-mail.')]")
	WebElement checkBox;

	@FindBy(xpath = "//div[contains(text(),'I am flying as the primary passenger')]")
	WebElement checkBoxPrimary;

	@FindBy(xpath = "//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement fNameP1;

	@FindBy(xpath = "//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement lNameP1;

	@FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement mobileNumberP1;

	@FindBy(xpath = "//div[@data-testid='traveller-0-travel-info-cta']")
	WebElement next;

	@FindBy(xpath = "//input[@data-testid='traveller-1-first-traveller-info-input-box']")
	WebElement fNameP2;

	@FindBy(xpath = "//input[@data-testid='traveller-1-last-traveller-info-input-box']")
	WebElement lNameP2;

	@FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement mobileNumberP2;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement passengerContinue;

	@FindBy(xpath = "(//div[text()='Continue'])[3]")
	WebElement addsonContinue;

	@FindBy(xpath = "(//span[text()='Skip this to skip comfort.'])[1]")
	WebElement skipPopUp;

	@FindBy(xpath = "//iframe[@class='card_number_iframe']")
	WebElement cnoframe;

	@FindBy(xpath = "//input[@id='card_number']")
	WebElement cardNumber;

	@FindBy(xpath = "//iframe[@class='name_on_card_iframe']")
	WebElement cardNameframe;

	@FindBy(xpath = "//input[@placeholder='Cardholder Name']")
	WebElement cardName;

	@FindBy(xpath = "//iframe[@class='card_exp_month_iframe']")
	WebElement cexpframe;

	@FindBy(xpath = "//input[@id='card_exp_month']")
	WebElement card_exp_month;

	@FindBy(xpath = "//iframe[@class='card_exp_year_iframe']")
	WebElement cexpyearFrame;

	@FindBy(xpath = "//input[@id='card_exp_year']")
	WebElement card_exp_year;

	@FindBy(xpath = "//iframe[@class='security_code_iframe']")
	WebElement cvvFrame;

	@FindBy(xpath = "//input[@id='security_code']")
	WebElement cvvCode;

	@FindBy(xpath = "(//div[@data-testid='common-proceed-to-pay'])")
	WebElement payButton;

	@FindBy(xpath = "//div[text()='Proceed to pay']")
	WebElement payCheck;

	// pagefactory intialization
	public FlightBookingPage() {

		PageFactory.initElements(driver, this);
	}

	// Method for selecting the flight & booking the flight
	public void bookingPayment(String town, String nameP1, String nameLP1, String phnP1, String nameP2, String nameLP2,
			String phnP2, String cardNo, String cName, String cardMonth, String cardYear, String cvvNo)
			throws Exception {

		// selecting the flight
		pageWait(50);
		waitImplicit(40);
		pageWait(50);
		waitExplicit(conFlightIcon, 80);
		nrmlClick(conFlightIcon);

		// Filling the passenger details
		pageWait(50);
		waitExplicit(city, 30);
		textKey(city, town);
		waitExplicit(checkBox, 30);
		nrmlClick(checkBox);
		waitExplicit(checkBoxPrimary, 30);
		nrmlClick(checkBoxPrimary);
		waitExplicit(fNameP1, 30);
		textKey(fNameP1, nameP1);
		waitExplicit(lNameP1, 30);
		textKey(lNameP1, nameLP1);
		waitExplicit(mobileNumberP1, 30);
		textKey(mobileNumberP1, phnP1);
		waitExplicit(next, 30);
		nrmlClick(next);
		waitExplicit(fNameP2, 30);
		textKey(fNameP2, nameP2);
		waitExplicit(lNameP2, 30);
		textKey(lNameP2, nameLP2);
		waitExplicit(mobileNumberP2, 30);
		textKey(mobileNumberP2, phnP2);
		waitExplicit(passengerContinue, 30);
		nrmlClick(passengerContinue);

		// Screenshot for passenger page
		screenshot("PassengerPage");

		// adds on page
		pageWait(50);
		Thread.sleep(5000);
		waitExplicit(addsonContinue, 30);
		jClick(addsonContinue);
		;
		jClick(skipPopUp);

		// Payment page
		pageWait(50);
		waitExplicit(cnoframe, 30);
		frameSwitch(cnoframe, cardNo, cardNumber);
		waitExplicit(cardNameframe, 30);
		frameSwitch(cardNameframe, cName, cardName);
		waitExplicit(cexpframe, 30);
		frameSwitch(cexpframe, cardMonth, card_exp_month);
		waitExplicit(cexpyearFrame, 30);
		frameSwitch(cexpyearFrame, cardYear, card_exp_year);
		waitExplicit(cvvFrame, 30);
		frameSwitch(cvvFrame, cvvNo, cvvCode);

		waitExplicit(payButton, 30);
		buttonClick(payButton);

		screenshot("Payement Page");

		String actual = elementText(payCheck);

		Assert.assertEquals(actual, "Proceed to pay");
	}

}
