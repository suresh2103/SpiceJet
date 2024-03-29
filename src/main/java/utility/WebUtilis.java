package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebUtilis extends JavaUtilis {

	public static WebDriver driver = null;
	public static ExtentHtmlReporter html = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;

	// Method for scroll & click clicking the element using java script Executor
	public static void buttonClick(WebElement element) {

		waitExplicit(element, 10);
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true)", element);
			element.click();
			test.log(Status.INFO, "Element is Clicked");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Method for clicking the element using java script Executor
	public static void jClick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
			test.log(Status.INFO, "Element is Clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method for direct click
	public static void nrmlClick(WebElement element) {

		try {
			element.click();
			test.log(Status.INFO, "Element is Clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method for sending Key to text box
	public static void textKey(WebElement element, String value) {

		element.sendKeys(value);
		test.log(Status.INFO, "Text is updated");
	}

	// Method for Implicit wait
	public static void waitImplicit(int value) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
	}

	// Method for getText
	public static String elementText(WebElement element) {

		waitExplicit(element, 5);
		String value = element.getText();
		return value;
	}

	// Method to check the Url
	public static String getURL() {

		String value = driver.getCurrentUrl();

		return value;
	}

	// Method for Explicit wait
	public static void waitExplicit(WebElement element, int value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method for waitExplicit only by clickable
	public static void waitClickable(WebElement element, int value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Method for dropdown by value
	public static void dropDown(WebElement element, String value) {

		Select sel = new Select(element);

		sel.selectByValue(value);
	}

	// Method alert box
	public static String messageAlert(WebElement element) {

		waitExplicit(element, 5);
		String value = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		return value;
	}

	// Method to take ScreenShot
	public static String getScreenShot(String screenshotName) {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		String path = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			File destination = new File(path);

			FileHandler.copy(source, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	// Get ScreenShot Method
	public static void screenshot(String imageName) {
		try {
			test.addScreenCaptureFromPath(getScreenShot(imageName));
		} catch (Exception e) {
			System.out.println("Error in Screenshot");
		}
	}

	// Switching Between Windows
	public static void windowSwitch(WebElement element) {
		try {
			String originalWindow = driver.getWindowHandle();
			buttonClick(element);
			for (String windowHandle : driver.getWindowHandles()) {
				if (!originalWindow.equals(windowHandle)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	// Method for DatePicker
	public static void datePick(String element, String date) {
		try {
			List<WebElement> dateTag = driver.findElements(By.xpath(element));
			for (WebElement pickDate : dateTag) {
				if (pickDate.getText().equals(date)) {
					pickDate.click();
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	// To Reload the window
	public static void reload() {

		driver.navigate().refresh();
	}

	// Method to scroll the window
	public static void scroll() {

		JavascriptExecutor key = (JavascriptExecutor) driver;

		key.executeScript("window.scrollBy(0,1000)");

	}

	// Validate the element is present or not
	public static boolean elementValidate(WebElement element) {

		if (element.isDisplayed()) {

			return true;
		} else
			return false;
	}

	// Method to get the Title of the Page
	public static String getTitle() {

		String value = driver.getTitle();

		return value;
	}

	// Actions class method to move the page up
	public static void pageUp() {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
	}

	// Actions class method to select the element
	public static void selectElement(WebElement element) {

		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
	}

	// wait Method for page load
	public static void pageWait(int value) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(value));
	}

	// method for switching frames
	public static void frameSwitch(WebElement elementFrame, String value, WebElement element) {

		driver.switchTo().frame(elementFrame);

		textKey(element, value);

		driver.switchTo().defaultContent();
	}
}
