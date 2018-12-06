package com.entaly;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.entaly.commonutils.FunctionalCommonUtils;
import com.entaly.pages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenitySystemProperties;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class StepDefinition {
	public static WebDriver driver;
	@Steps
	FunctionalCommonUtils commonutilfunc;
	LoginPage loginPage = new LoginPage();

	@Before
	public void beforeEveryScenrio(Scenario scenario) throws IOException {
		String property = SerenitySystemProperties.getProperties()
				.getValue(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		String myCustomProperty = variables.getProperty("env.platform");
		switch (myCustomProperty) {
		case "dev":
			baseUrl = "http://google.com";
			break;
		case "qa":
			baseUrl = "http://entalyapi.eastus.cloudapp.azure.com:4375";
			break;
		case "grid":
			if (variables.getProperty("webdriver.driver").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				chromeOptions.setExperimentalOption("useAutomationExtension", false);
				ChromeDriver driver = new ChromeDriver(chromeOptions);
				baseUrl = "http://boa-launch-web.dindc.g4ihos.itcs.hpecorp.net";
				driver.get(baseUrl);
				break;
			} else {
				System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				FirefoxDriver driver = new FirefoxDriver(options);
				baseUrl = "http://boa-launch-web.dindc.g4ihos.itcs.hpecorp.net";
				break;
			}
		}
		Serenity.setSessionVariable("url").to(baseUrl);
	}

	@After
	public void afterEveryScenrio(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) loginPage.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		// launchPage.getDriver().quit();
	}

}