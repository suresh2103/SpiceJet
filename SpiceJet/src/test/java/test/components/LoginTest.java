package test.components;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.components.BaseEngine;
import page.components.LoginPage;

public class LoginTest extends BaseEngine {

	// Login for valid functions
	@Test(priority = 1, groups = { "Smoke", "Regression" })
	public void signinTc01() throws Exception {

		test = report.createTest("Tc01-Sign-in with valid Credentials");

		LoginPage validLogin = new LoginPage();

		validLogin.signIn(readingExcel("Signin", 1, 0), readingExcel("Signin", 1, 1));

		test.log(Status.PASS, "Sign-in Succesfull");
	}

	// Login with invalid username & valid password
	@Test(priority = 2, groups = { "Regression" })
	public void signinTc02() throws Exception {

		test = report.createTest("Tc02-Sign-in with invalid username & valid password");

		LoginPage LoginTc02 = new LoginPage();

		LoginTc02.invalidSignin(readingExcel("Signin", 2, 0), readingExcel("Signin", 2, 1));

		test.log(Status.PASS, "Signin un-Succesfull");
	}

	// Login with valid username & invalid password
	@Test(priority = 2, groups = { "Regression" })
	public void signinTc03() throws Exception {

		test = report.createTest("Tc03-Sign-in with valid username & invalid password");

		LoginPage LoginTc03 = new LoginPage();

		LoginTc03.invalidSignin(readingExcel("Signin", 3, 0), readingExcel("Signin", 3, 1));

		test.log(Status.PASS, "Signin un-Succesfull");
	}

	// Login with valid inusername & invalid password
	@Test(priority = 2, groups = { "Regression" })
	public void signinTc04() throws Exception {

		test = report.createTest("Tc04-Sign-in with invalid username & invalid pass");

		LoginPage LoginTc04 = new LoginPage();

		LoginTc04.invalidSignin(readingExcel("Signin", 4, 0), readingExcel("Signin", 4, 1));

		test.log(Status.PASS, "Signin un-Succesfull");
	}
}