package base.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.WebUtilis;

public class BaseEngine extends WebUtilis {

	// open the report
	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {

		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(html);
	}

	// open the browser & Url Link
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public static void beforeMethod(String browser) throws Exception {

		if (browser.equalsIgnoreCase("firefox")) {
		
			driver = new FirefoxDriver( );
			
		} else if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(openURL("link"));
	}

	// after method report
	@AfterMethod(alwaysRun = true)
	public static void afterMethod() {
		
		report.flush();
		driver.quit();
		
	}

}