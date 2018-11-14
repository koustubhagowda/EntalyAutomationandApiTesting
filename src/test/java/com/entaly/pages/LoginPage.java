package com.entaly.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.entaly.commonutils.FunctionalCommonUtils;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

	FunctionalCommonUtils CommonUtil = new FunctionalCommonUtils();

	@FindBy(xpath = "//button[@class='borderLess navbar-toggler']")
	public WebElementFacade hambarger_button;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElementFacade login;

	@FindBy(xpath = "//input[@type='text']")
	public WebElementFacade loginemail;

	@FindBy(xpath = "//*[@id='loginFormEmail']/div[1]/button")
	public WebElementFacade next;

	@FindBy(xpath = "//input[@type='password']")
	public WebElementFacade password;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade submit;

	@FindBy(xpath = "(//div[@class='padding-top-box card-box center-text'])[1]")
	public WebElementFacade dashboard_page;

	@FindBy(xpath = "//*[@id='root']/div[1]/nav/ol/span[2]/a")
	public WebElementFacade report_list;

	@FindBy(xpath = "//small[@class='fontSize12 form-text text-danger']")
	public WebElementFacade verify;

	@FindBy(xpath = ".//div[@id='powerbi-report']/iframe")
	public WebElementFacade report_verify;

	@FindBy(xpath = "//div[@class='forgotpassword cursor-pointer']")
	public WebElementFacade forgotpaswrd;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade resetpswrd_next;

	@FindBy(xpath = "//input[@name='identifier']")
	public WebElementFacade gmail_email;

	@FindBy(xpath = "(//span[@class='RveJvd snByac'])[1]")
	public WebElementFacade gmail_next;

	@FindBy(xpath = "//input[@name='password']")
	public WebElementFacade gmail_password;

	@FindBy(xpath = "//a[@class='WaidBe']")
	public WebElementFacade gmail_button;

	@FindBy(xpath = "//div[2]/div/table/tbody/tr[1]")
	public WebElementFacade gmail_frst_div;

	@FindBy(xpath = "//center[3]/a")
	public WebElementFacade reset_link;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	public WebElementFacade new_password;

	@FindBy(xpath = "(//input[@type='password'])[3]")
	public WebElementFacade confirm_password;

	@FindBy(xpath = "//div[3]/button")
	public WebElementFacade reset_submit;

	public WebElementFacade getUniqueElementInPage() {
		return reset_link;
	}

	public void loginblank() throws InterruptedException {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(next);
		next.click();
	}

	public void verify_blank_email() throws InterruptedException {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter the email id", actual);

	}

	public void invalid_email(String invalemail) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(invalemail);
		CommonUtil.waitForElement(next);
		next.click();
	}

	public void verify_invalid_email() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Email id does not exist, please enter a valid email id", actual);
	}

	public void password_blank(String email) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(email);
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(submit);
		submit.click();
	}

	public void verify_blank_password() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter the password", actual);
	}

	public void valemail_with_two_attempts(String valemail, String invalpswrd) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(valemail);
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(password);
		password.sendKeys(invalpswrd);
		CommonUtil.waitForElement(submit);
		submit.click();
	}

	public void verify_two_attempt_text() {
		String actual = getDriver()
				.findElement(By.xpath("//small[text()='Bad credentials! You are left with 2 more attempts']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Bad credentials! You are left with 2 more attempts", actual);
	}

	public void invalid_password(String invalpswrd) {

		CommonUtil.waitForElement(password);
		password.sendKeys(invalpswrd);
		CommonUtil.waitForElement(submit);
		submit.click();
		CommonUtil.waitForElement(submit);

	}

	public void verify_one_attempt_text() {
		String actual = getDriver()
				.findElement(By.xpath("//small[text()='Bad credentials! You are left with 1 more attempt']")).getText();
		System.out.println(actual);
		Assert.assertEquals("Bad credentials! You are left with 1 more attempt", actual);
	}

	public void verify_account_locked_text() {

		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Bad credentials! Account is locked", actual);
	}

	public void valid_login(String valemail, String valpswrd) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(valemail);
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(password);
		password.sendKeys(valpswrd);
		CommonUtil.waitForElement(submit);
		submit.click();

	}

	public void dashboard_page_verify() {
		String actual = getDriver().findElement(By.xpath("//span[@class='row-heading']")).getText();
		System.out.println(actual);
		Assert.assertEquals("Intelligent Applications", actual);

	}

	public void dasboard_page() {
		CommonUtil.waitTillElementVisibility(By.xpath("//*[@id='root']/div[1]/div/div[2]/a[1]/div"));
		getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div/div[2]/a[1]/div")).click();
		// loginobj.dashboard_page.click();

	}

	public void report_verify() throws InterruptedException {

		int size = getDriver().findElements(By.xpath("//div[1]/div[1]/div/div/div")).size();
		System.out.println(size);
		for (int i = 1; i <= size; i++) {
			WebElement element = getDriver().findElement(By.xpath("//div[1]/div[1]/div/div/div[" + i + "]"));
			CommonUtil.waitForElement(element);
			element.click();
			CommonUtil.waitForPageLoaded();
			boolean verify = report_verify.isDisplayed();
			System.out.println(verify);
			CommonUtil.waitForElement(report_list);
			report_list.click();

		}
	}

	public void reset_password(String valemail) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(valemail);
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(forgotpaswrd);
		forgotpaswrd.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(valemail);
		CommonUtil.waitForElement(submit);
		submit.click();
	}

	public void navigate_email() {
		getDriver().manage().window().maximize();
		getDriver().get("https://accounts.google.com");// here mention mail id
														// url
		gmail_email.sendKeys("kkeshavaswamy@qwinix.io");
		CommonUtil.waitForElement(gmail_next);
		gmail_next.click();
		CommonUtil.waitForElement(gmail_password);
		gmail_password.sendKeys("keshav1994,");
		CommonUtil.waitForElement(gmail_next);
		gmail_next.click();
		gmail_button.click();
		CommonUtil.waitForElement(gmail_frst_div);
		gmail_frst_div.click();
		WebElement element = getDriver().findElement(By.xpath("//center[3]/a"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		CommonUtil.waitForElement(reset_link);
		String token = reset_link.getText();
		System.out.println(token);
		String Code = getDriver().findElement(By.xpath("//center[3]/a")).getText();
		String[] parts = Code.split("token=");
		System.out.println(parts);
		String access_token = parts[1];
		parts = access_token.split("&email=kkeshavaswamy@qwinix.io");
		access_token = parts[0];
		System.out.println(access_token);
		CommonUtil.waitForElement(reset_link);
		reset_link.click();
		// CommonUtil.waitForPageLoaded();

	}

	public void resetemail_blank() {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys("kkeshavaswamy@qwinix.io");
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(forgotpaswrd);
		forgotpaswrd.click();
		CommonUtil.waitForElement(submit);
		submit.click();

	}

	public void verify_reset_blank_email() throws InterruptedException {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter the Email ID", actual);
	}

	public void reset_invalemail(String invalemail) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys("kkeshavaswamy@qwinix.io");
		CommonUtil.waitForElement(next);
		next.click();
		CommonUtil.waitForElement(forgotpaswrd);
		forgotpaswrd.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(invalemail);
		CommonUtil.waitForElement(submit);
		submit.click();

	}

	public void rsetpswrd_empty() {
		navigate_email();
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(0));
		getDriver().close();
		getDriver().switchTo().window(tabs2.get(1));
		reset_submit.click();
	}

	public void verify_resetpswrd_empty() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 errorMsg form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("New Password cannot be empty", actual);
	}

	public void newpswrd_empty(String pswrd) {
		// navigate_email();
		// ArrayList<String> tabs2 = new ArrayList<String>
		// (driver.getWindowHandles());
		// driver.switchTo().window(tabs2.get(0));
		// driver.close();
		// driver.switchTo().window(tabs2.get(1));
		// CommonUtil.waitForPageLoaded();
		confirm_password.sendKeys(pswrd);
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();

	}

	public void confirm_pswrd_empty() {
		CommonUtil.waitForElement(new_password);
		new_password.sendKeys("123");
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();

	}

	public void verify_confirm_empty_pswrd() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 errorMsg form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Confirm Password cannot be empty", actual);
	}

	public void pswrd_mismatch() {
		CommonUtil.waitForElement(new_password);
		new_password.sendKeys("Password1234");
		CommonUtil.waitForElement(confirm_password);
		confirm_password.sendKeys("password");
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();

	}

	public void verify_pswrd_mismatch() {
		CommonUtil.waitForPageLoaded();
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 errorMsg form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("The Passwords do not match. Please try again.", actual);

	}

	public void invalid_resetpswrd() {
		CommonUtil.waitForElement(new_password);
		new_password.sendKeys("password");
		CommonUtil.waitForElement(confirm_password);
		confirm_password.sendKeys("password");
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();

	}

	public void verify_invalid_resetpswrd() {
		CommonUtil.waitForPageLoaded();
		String actual = getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div/div[1]/small")).getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter valid password.", actual);
	}
}
