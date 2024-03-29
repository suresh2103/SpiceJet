package page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.WebUtilis;

public class LoginPage extends WebUtilis {

	// WebElements
	@FindBy(xpath = "//div[text()='Login']")
	WebElement signinIcon;

	@FindBy(xpath = "//input[@type='number']")
	WebElement mobileNo;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//div[text()='LOGIN']//parent::div)[1]")
	WebElement loginButton;

	@FindBy(xpath = "//div[text()='Hi suresh']")
	WebElement userText;

	@FindBy(xpath = "//div[text()='Log Out']")
	WebElement logout;

	// pagefactory intialization
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Method for valid sign in
	public void signIn(String phoneNumber, String passKey) throws Exception {

		waitImplicit(5);
		buttonClick(signinIcon);
		waitExplicit(signinIcon, 5);
		textKey(mobileNo, phoneNumber);
		textKey(password, passKey);
		buttonClick(loginButton);
		waitExplicit(loginButton, 5);

		pageWait(40);
		String actual = elementText(userText);

		Assert.assertEquals(actual, "Hi Suresh");

		screenshot("validSignin");

		buttonClick(userText);
		buttonClick(logout);

	}

	// Method for Invalid signin
	public void invalidSignin(String phoneNumber, String passKey) throws Exception {

		waitImplicit(5);
		buttonClick(signinIcon);
		waitExplicit(signinIcon, 5);
		textKey(mobileNo, phoneNumber);
		textKey(password, passKey);
		buttonClick(loginButton);
		waitExplicit(loginButton, 5);
		screenshot("invalidSignin");

		Assert.assertTrue(true, "Login UnSuccessfull");

	}

	// Method for signin & navigate to next process
	public void signinBooking(String phoneNumber, String passKey) throws Exception {

		waitImplicit(5);
		buttonClick(signinIcon);
		waitExplicit(signinIcon, 5);
		textKey(mobileNo, phoneNumber);
		textKey(password, passKey);
		buttonClick(loginButton);
		waitExplicit(loginButton, 5);

		pageWait(80);
		String actual = elementText(userText);

		Assert.assertEquals(actual, "Hi Suresh");

	}

}