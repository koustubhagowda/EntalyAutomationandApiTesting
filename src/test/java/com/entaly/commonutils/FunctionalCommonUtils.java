package com.entaly.commonutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

import com.entaly.pages.LoginPage;

import net.thucydides.core.annotations.findby.By;

import gherkin.deps.com.google.gson.Gson;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class FunctionalCommonUtils extends PageObject {
	public static String json = "";
	LoginPage login;

	// To Open Particular URL
	public void openUrl(String url) throws InterruptedException {
		String browserType = getDataFromProperties("webdriver.driver");
		System.out.println(browserType);
		if (browserType.equalsIgnoreCase("chrome")) {
			Thread.sleep(1000);
			login.openAt(url);
			getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			System.out.println("running first one");
			Thread.sleep(15000);
			System.out.println("running second one");
			// waitForPageLoaded();
			/*
			 * pressEnterBtn(); handleWindowCertificate(); System.out.println(
			 * "running third one"); handleWindowSmartCard();
			 */
		} else if (browserType.equalsIgnoreCase("firefox")) {
			login.openAt(url);
			getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			waitForPageLoaded();
			checkPageIsReady();
			waitForPageLoaded();
		} else {
			login.openAt(url);
			getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			getDriver().manage().deleteAllCookies();
			browserMaximize();
			Thread.sleep(10000);
			handleWindowSmartCard();
			Thread.sleep(8000);

		}
	}

	// To handle Window SmartCard details
	public void handleWindowSmartCard() {
		try {
			Thread.sleep(2000);
			Screen s = new Screen();
			if (s.exists("./WindowsPopUpImages/PinImage.png") != null) {
				s.type("./WindowsPopUpImages/PinImage.png", "97409736");
				s.click("./WindowsPopUpImages/OKButton.png");
			} else {
				s.wait("./WindowsPopUpImages/PinImage.png", 80);
				s.type("./WindowsPopUpImages/PinImage.png", "97409736");
				s.click("./WindowsPopUpImages/OKButton.png");
			}
		} catch (Exception e) {
			return;
		}
	}

	// To handle Window Certification details
	public void handleWindowCertificate() {
		try {
			Thread.sleep(2000);
			Screen s = new Screen();
			System.out.println(s.exists("./WindowsPopUpImages/CertificateOkButton.png"));
			if (s.exists("./WindowsPopUpImages/CertificateOkButton.png") != null) {
				System.out.println(s.exists("./WindowsPopUpImages/CertificateOkButton.png"));
				s.click("./WindowsPopUpImages/CertificateOkButton.png");
			} else {
				s.wait("./WindowsPopUpImages/CertificateOkButton.png", 80);
				s.click("./WindowsPopUpImages/CertificateOkButton.png");
			}
		} catch (Exception e) {
			return;
		}
	}

	// To get data from serenity properties file
	public String getDataFromProperties(String key) {
		String property = SerenitySystemProperties.getProperties()
				.getValue(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		String myCustomProperty = variables.getProperty(key);
		return myCustomProperty;
	}

	// To Validate Textfield
	public boolean getValidUserName(String textfield) {
		boolean validNameFlag = false;
		int nameLength = textfield.length();
		boolean isNumeric = textfield.chars().allMatch(Character::isDigit);
		Pattern pattern = Pattern.compile(new String("^[a-zA-Z0-9]{3,25}$"));
		Matcher matcher = pattern.matcher(textfield);
		System.out.println("is numeric :" + isNumeric + " patter match : " + matcher.matches());
		if (matcher.matches() && !isNumeric) {
			validNameFlag = true;
			// System.out.println("validNameFlag" + validNameFlag);
			return validNameFlag;
		}
		// System.out.println("validNameFlag out" + validNameFlag);
		return validNameFlag;
	}

	// To check button is enabled or not it returns booean value
	public boolean checkBtnIsEnabled(WebElement button) {
		String classes = button.getAttribute("class"); // IF BUTTON DISSABLE IT
														// RETURNS true
		boolean isDisabled = classes.contains("grommetux-button grommetux-button--disabled sc-fAjcbJ dqDkDN");
		return isDisabled;
	}

	// Maximize all the browsers
	public void browserMaximize() {
		String property = SerenitySystemProperties.getProperties()
				.getValue(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		String myCustomProperty = variables.getProperty("webdriver.driver");
		if (myCustomProperty.equals("firefox")) {
		} else {
			getDriver().manage().window().maximize();
		}
	}

	// To click on ENTER button in keyboard
	public void pressEnterBtn() {
		try {
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(200);
		} catch (Exception e) {
			return;
		}
	}

	// To click on element using Javascript
	public void clickOnElementUsingJavascript(WebElement ele) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", ele);
	}

	// To click on element using Action class
	public void clickOnElementUsingAction(WebElement ele) {
		Actions action = new Actions(getDriver());
		action.moveToElement(ele).click().perform();
	}

	// To scroll page to bottom
	public void scrollTopToBottom() {
		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(200,400)");
		} catch (Exception e) {
			return;
		}
	}

	// To scroll page to top
	public void scrollBottomToTop() {
		try {
			((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(200,-400)");
		} catch (Exception e) {
			return;
		}
	}

	public void scroll(WebElementFacade we) {
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(getDriver());
		eventFiringWebDriver.executeScript("document.getElementById('we').scrollTop = 200");
	}

	// To move mouse on particaular element using action class and click on
	// element
	public void moveToElementAndClick(WebElementFacade WE, String data) {
		try {
			Actions action = new Actions(getDriver());
			action.moveToElement(WE).click().sendKeys(data).perform();
		} catch (Exception e) {
			return;
		}
	}

	// To move mouse on particaular element using action class and send data
	public void moveToElementAndSendData(WebElementFacade WE, String data) {
		try {
			Actions action = new Actions(getDriver());
			action.moveToElement(WE).click().sendKeys(data).perform();
		} catch (Exception e) {
			return;
		}
	}

	// To select particular date
	public void selectDate(String yearandmonth, String date) {
		try {
			// Click on Next arrow untill we get desired year and desired month
			String currentYearAndMonth = getDriver().findElement(org.openqa.selenium.By.xpath("//header/div/span"))
					.getText();
			if (currentYearAndMonth.equalsIgnoreCase(yearandmonth)) {
			} else {
				do {
					getDriver().findElement(org.openqa.selenium.By.xpath("//button[@aria-label='Next Month']")).click();
				} while (!getDriver().findElement(org.openqa.selenium.By.xpath("//header/div/span")).getText()
						.equalsIgnoreCase(yearandmonth));
			}
			// Select desired date of the month
			List<WebElement> currdate = getDriver().findElements(org.openqa.selenium.By
					.xpath("//div[@class='grommetux-date-time-drop__grid']//table//tbody//tr//td"));
			for (WebElement d : currdate) {
				if (d.getText().trim().equalsIgnoreCase(date)) {
					d.click();
					break;
				}
			}
		} catch (Exception e) {
			return;
		}
	}

	// To select previous dates
	public void selectPreviousDate(String yearandmonth, String date) {
		try {
			// Click on Next arrow untill we get desired year and desired month
			String currentYearAndMonth = getDriver().findElement(By.xpath("//header/div/span")).getText();
			if (currentYearAndMonth.equalsIgnoreCase(yearandmonth)) {
			} else {
				do {
					getDriver().findElement(By.xpath("//button[@aria-label='Previous Month']")).click();
				} while (!getDriver().findElement(By.xpath("//header/div/span")).getText()
						.equalsIgnoreCase(yearandmonth));
			}
			// Select desired date of the month
			List<WebElement> currdate = getDriver()
					.findElements(By.xpath("//div[@class='grommetux-date-time-drop__grid']//table//tbody//tr//td"));
			for (WebElement d : currdate) {
				if (d.getText().trim().equalsIgnoreCase(date)) {
					d.click();
					break;
				}
			}
		} catch (Exception e) {
			return;
		}
	}

	// select the dropdown using "select by visible text", pass VisibleText
	public static void selectByVisibleText(WebElement WE, String VisibleText) {
		try {
			Select selObj = new Select(WE);
			selObj.selectByVisibleText(VisibleText);
		} catch (Exception e) {
			return;
		}
	}

	// select the dropdown using "select by index", so pass IndexValue '
	public static void selectByIndex(WebElement WE, int IndexValue) {
		try {
			Select selObj = new Select(WE);
			selObj.selectByIndex(IndexValue);
		} catch (Exception e) {
			return;
		}
	}

	// select the dropdown using "select by value", so pass Value
	public static void selectByValue(WebElement WE, String Value) {
		try {
			Select selObj = new Select(WE);
			selObj.selectByValue(Value);
		} catch (Exception e) {
			return;
		}
	}

	// To upload images
	public static void uploadImage(WebElement WE, String path) {
		try {
			StringSelection sel = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
			WE.click();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);

			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}
		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

	// validate Success Message
	public static void validate(String expRes, WebElement WE) {
		try {
			Assert.assertEquals(expRes, WE.getText());
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

	// Wait for the Element
	public void waitForElement(WebElement WE) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(WE));
	}

	// Wait for the Element to be found
	public void waitTillElementFound(WebElement ElementTobeFound, int seconds) {
		WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
		wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
	}

	public void waitTillPresenceElement(org.openqa.selenium.By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitTillElementVisibility(org.openqa.selenium.By by) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void implicitWait() {
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(21000);
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static String MapToJSonString(Map<String, String> body) {
		try {
			Gson gson = new Gson();
			json = gson.toJson(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	public static String MapToJSonStringObject(Map<String, Object> body) {
		try {
			Gson gson = new Gson();
			json = gson.toJson(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	// Conver Map to Json String
	public static String MapToJSonStringInteger(Map<String, Integer> body) {
		try {
			Gson gson = new Gson();
			json = gson.toJson(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	// Json file compared
	public static void JsonStringCompare(String json, String body) throws JSONException {
		JSONCompareResult result = JSONCompare.compareJSON(body, json, JSONCompareMode.STRICT);
		System.out.println(result.toString());
	}

	// Convert Json String to Objecct
	public static JSONObject ConvertJsonStringToJsonObject(String json) throws JSONException {
		JSONObject childjson = new JSONObject(json);
		return childjson;
	}

	// read from the json and send that as a string
	public static String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	public static String readFile(String filename) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static JSONObject readFileObject(String filename) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object object = parser.parse(new FileReader(filename));
			// convert Object to JSONObject
			jsonObject = (JSONObject) object;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	// Convert Json file to Json String
	public static String JSonFiletoJsonString(String JsonFile) {
		try {
			Gson gson = new Gson();
			json = gson.toJson(JsonFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	// Convert Json file to Json String
	public static String JSonStringtoJsonFile(String JsonString) {
		JSONParser parser = new JSONParser();
		try {
			Object object = parser.parse(JsonString);

			// convert Object to JSONObject
			// JSONObject jsonObject = (JSONObject)object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonString;
	}

	public void waitForTimeFiveMinute() {
		try {
			// Thread.sleep(300000);
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForTimeBelowFiveMinute() {
		try {
			// Thread.sleep(300000);
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitForTimeOneHour() {
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
