package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.WebUtilis;

public class SignUpPage extends WebUtilis {

	// Web elements
	@FindBy(xpath = "//a//div[contains(text(),'Signup')]")
	WebElement signUpIcon;

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement title;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lName;

	@FindBy(xpath = "(//div[@class='row']//child::select)[2]")
	WebElement country;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dob;

	@FindBy(xpath = "(//div[@class='react-datepicker__header ']//child::select)[1]")
	WebElement month;

	@FindBy(xpath = "(//div[@class='react-datepicker__header ']//child::select)[2]")
	WebElement year;

	String datePicker = "//div[@class='react-datepicker__week']//child::div";

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobileNo;

	@FindBy(xpath = "//*[@id='email_id']")
	WebElement emailId;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement confirmPassKey;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement terms;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submit;

//pagefactory intialization
	public SignUpPage() {

		PageFactory.initElements(driver, this);

	}

	// Method for valid account creation
	public void validSignUp(String value, String firstName, String lastName, String nation, String phnNo, String mailId,
			String passKey, String reKey, String dobMonth, String dobYear, String date) throws Exception {

		windowSwitch(signUpIcon);
		pageWait(30);
		waitExplicit(title, 10);
		dropDown(title, value);
		waitExplicit(fName, 40);
		textKey(fName, firstName);
		waitExplicit(lName, 40);
		textKey(lName, lastName);
		waitExplicit(country, 40);
		dropDown(country, nation);
		waitExplicit(dob, 40);
		jClick(dob);
		Thread.sleep(1500);
		dropDown(month, dobMonth);
		dropDown(year, dobYear);
		datePick(datePicker, date);
		waitExplicit(mobileNo, 40);
		textKey(mobileNo, phnNo);
		Thread.sleep(1500);
		waitExplicit(emailId, 40);
		buttonClick(emailId);
		textKey(emailId, mailId);
		waitExplicit(password, 40);
		textKey(password, passKey);
		waitExplicit(confirmPassKey, 40);
		textKey(confirmPassKey, reKey);
		Thread.sleep(1500);
		waitExplicit(terms, 40);
		jClick(terms);
		waitExplicit(submit, 30);
		jClick(submit);

		screenshot("AccountCreation");

		String actual = getTitle();

		Assert.assertEquals(actual, "SpiceClub - The frequent flyer program of SpiceJet");

	}

}