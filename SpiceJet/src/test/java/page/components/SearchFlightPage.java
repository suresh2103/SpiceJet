package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class SearchFlightPage extends WebUtilis {

	// WebElements
	@FindBy(xpath = "(//div[.='one way'])[2]")
	WebElement oneWayButton;

	@FindBy(xpath = "//div[@data-testid='round-trip-radio-button']")
	WebElement roundTripButton;

	@FindBy(xpath = "(//input)[1]")
	WebElement fromText;

	@FindBy(xpath = "//*[text()='To']")
	WebElement toText;

	@FindBy(xpath = "//*[text()='Delhi']")
	WebElement toCity;

	@FindBy(xpath = "(//div[text()='21'])[1]")
	WebElement departureDate;

	@FindBy(xpath = "(//div[text()='24'])[1]")
	WebElement returnDate;

	@FindBy(xpath = "(//div[@data-testid='home-page-travellers'])")
	WebElement passengersClick;

	@FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
	WebElement adult;

	@FindBy(xpath = "//div[@data-testid='home-page-travellers-done-cta']")
	WebElement passengersSubmit;

	@FindBy(xpath = "//div[.='Currency']")
	WebElement currency;

	@FindBy(xpath = "(//div[text()='INR'])[2]")
	WebElement currencySubmit;

	@FindBy(xpath = "//*[@data-testid='home-page-flight-cta']")
	WebElement searchIcon;

	@FindBy(xpath = "//div[text()='Search again']")
	WebElement searchAgain;

	@FindBy(xpath = "//*[text()='Modify Search']")
	WebElement checkText;

	@FindBy(xpath = "(//*[@data-testid='spiceflex-flight-select-radio-button-1'])[1]")
	WebElement selectFare;

	// pagefactory intialization
	public SearchFlightPage() {

		PageFactory.initElements(driver, this);
	}

	// Method for one way flight searching
	public void onewayFlight() throws Exception {

		pageUp();
		
		pageWait(50);
		waitExplicit(fromText, 50);
		nrmlClick(fromText);
		textKey(fromText, "BLR");
		pageWait(50);
		waitExplicit(toCity, 40);
		nrmlClick(toCity);
		waitExplicit(departureDate, 30);

		nrmlClick(departureDate);
		waitExplicit(passengersClick, 30);
		nrmlClick(passengersClick);
		waitExplicit(adult, 30);
		nrmlClick(adult);
		waitExplicit(currency, 30);
		nrmlClick(currency);
		waitExplicit(currencySubmit, 30);
		nrmlClick(currencySubmit);
		waitExplicit(searchIcon, 30);
		nrmlClick(searchIcon);
		pageWait(40);
	

		String actual = elementText(checkText);

		pageWait(40);
		screenshot("onewaysearch");

		Assert.assertEquals(actual, "Modify Search");
	}

	// Method for roundTrip flight searching
	public void roundTripFlight() throws Exception {
		
	
		pageUp();
		
		pageWait(50);
		waitExplicit(roundTripButton, 30);
		nrmlClick(roundTripButton);
		waitExplicit(fromText, 20);
		nrmlClick(fromText);
		textKey(fromText, "BLR");
		pageWait(50);
		waitExplicit(toCity, 40);
		nrmlClick(toCity);
		waitExplicit(departureDate, 30);

		nrmlClick(departureDate);
		waitExplicit(returnDate, 30);
		nrmlClick(returnDate);
		waitExplicit(passengersClick, 30);
		nrmlClick(passengersClick);
		waitExplicit(adult, 30);
		nrmlClick(adult);
		waitExplicit(currency, 30);
		nrmlClick(currency);
		waitExplicit(currencySubmit, 30);
		nrmlClick(currencySubmit);
		waitExplicit(searchIcon, 30);
		nrmlClick(searchIcon);

		String actual = elementText(checkText);

		pageWait(40);
		screenshot("RoundTripSearch");

		Assert.assertEquals(actual, "Modify Search");
	}

}