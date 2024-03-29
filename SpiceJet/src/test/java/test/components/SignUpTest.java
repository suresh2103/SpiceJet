package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.SignUpPage;

public class SignUpTest extends BaseEngine {

	// Test case for valid SignUp
	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void signUpTc01() throws Exception {

		test = report.createTest("Tc05-Sign-up with valid Credentials");

		SignUpPage validSignUp = new SignUpPage();

		validSignUp.validSignUp(readingExcel("Signup", 1, 0), readingExcel("Signup", 1, 1),
				readingExcel("Signup", 1, 2), readingExcel("Signup", 1, 3), readingExcel("Signup", 1, 4),
				readingExcel("Signup", 1, 5), readingExcel("Signup", 1, 6), readingExcel("Signup", 1, 7),
				readingExcel("Signup", 1, 8), readingExcel("Signup", 1, 9), readingExcel("Signup", 1, 10));

		test.log(Status.PASS, "Navigates to otp page");

	}

	// Test case for invalid SignUp
	@Test(priority = 2, groups = { "Regression" })
	public void signUpTc02() throws Exception {

		test = report.createTest("Tc06-Sign-up with invalid Credentials");

		SignUpPage inValidSignUp = new SignUpPage();

		inValidSignUp.validSignUp(readingExcel("Signup", 2, 0), readingExcel("Signup", 2, 1),
				readingExcel("Signup", 2, 2), readingExcel("Signup", 2, 3), readingExcel("Signup", 2, 4),
				readingExcel("Signup", 2, 5), readingExcel("Signup", 2, 6), readingExcel("Signup", 2, 7),
				readingExcel("Signup", 2, 8), readingExcel("Signup", 2, 9), readingExcel("Signup", 2, 10));

		test.log(Status.PASS, "Sign-up un-Succesfull");

	}

}