package com.entaly.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.entaly.StepDefinition;
import com.entaly.commonutils.FunctionalCommonUtils;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

	// public WebDriver driver = StepDefinition.driver;
	FunctionalCommonUtils CommonUtil = new FunctionalCommonUtils();
	Actions action;

	@FindBy(xpath = "(//button[@type='button'])[1]")
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

	@FindBy(xpath = "//div[@class='sc-bwzfXH hyolra']")
	public WebElementFacade dot_button;

	@FindBy(xpath = "//i[@class='material-icons box'] ")
	public WebElementFacade checkbox_button;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElementFacade ok_button;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElementFacade fullscreen_button;

	@FindBy(xpath = "//a[@href='/applicationReports/1']")
	public WebElementFacade inteligent_link;

	@FindBy(xpath = "(//div[@class='padding-top-box card-box center-text'])[3]")
	public WebElementFacade data_cleansing;

	@FindBy(xpath = "//input[@type='text']")
	public WebElementFacade search_text;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	public WebElementFacade go_button;

	@FindBy(xpath = "(//td[@class='align-middle orange font-weight-bold'])[1]")
	public WebElementFacade edit_firs_div;

	@FindBy(xpath = "(//button[@class='loginButton cursor-pointer cna-edit-btn'])[1]")
	public WebElementFacade edit_button;

	@FindBy(xpath = "(//input[@role='combobox'])[1]")
	public WebElementFacade edit_company_name;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	public WebElementFacade edit_affiliated_name;

	@FindBy(xpath = "//button[@class='loginButton cursor-pointer cna-save-btn']")
	public WebElementFacade edit_save_button;

	@FindBy(xpath = "//div[@id='tooltip']/div/span")
	public WebElementFacade fetch_text;

	@FindBy(xpath = "//*[@id='abc']")
	public WebElementFacade option_click;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
	public WebElementFacade ok_click;

	@FindBy(xpath = "//div[@class='swal-text']")
	public WebElementFacade verify_text;

	@FindBy(xpath = "//span[@class='cna-selectAll']")
	public WebElementFacade selectall_button;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElementFacade apply_selection;

	@FindBy(xpath = "(//input[@value='Kroger'])[1]")
	public WebElementFacade value_fetch;

	@FindBy(xpath = "(//i[@ class='material-icons tickMark'])[1]")
	public WebElementFacade frst_checkbox;

	@FindBy(xpath = "//small[@class='fontSize12 form-text text-danger']")
	public WebElementFacade login_errmsg;

	@FindBy(xpath = "//div[@class='noDataFound']")
	public WebElementFacade inval_errmsg;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElementFacade logout;

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

	public void verify__email_errors(String excepted) throws InterruptedException {
		String actual = login_errmsg.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);

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
		login.click();
		loginemail.sendKeys(valemail);
		next.click();
		password.sendKeys(valpswrd);
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

	public void report_verify() throws InterruptedException, AWTException {

		int size = getDriver().findElements(By.xpath("//div[1]/div[1]/div/div/div")).size();
		System.out.println(size);
		for (int i = 1; i <= size; i++) {
			WebElement element = getDriver().findElement(By.xpath("//div[1]/div[1]/div/div/div[" + i + "]"));
			CommonUtil.waitForElement(element);
			element.click();
			CommonUtil.waitForPageLoaded();
			boolean verify = report_verify.isDisplayed();
			System.out.println(verify);
			CommonUtil.waitForElement(fullscreen_button);
			fullscreen_button.click();
			CommonUtil.waitForPageLoaded();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			CommonUtil.waitForElement(inteligent_link);
			inteligent_link.click();

		}
	}

	public void forgot_email(String valemail) {
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
		CommonUtil.waitForPageLoaded();
		gmail_frst_div.click();
		WebElement element = getDriver().findElement(By.xpath("//center[3]/a"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		// CommonUtil.waitForElement(reset_link);
		String token = reset_link.getText();
		System.out.println(token);
		String Code = getDriver().findElement(By.xpath("//center[3]/a")).getText();
		String[] parts = Code.split("token=");
		System.out.println(parts);
		String accesstoken = parts[1];
		parts = accesstoken.split("&email=kkeshavaswamy@qwinix.io");
		accesstoken = parts[0];
		System.out.println(accesstoken);
		CommonUtil.waitForElement(reset_link);
		reset_link.click();
	}

	public void forgotemail_blank() {
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

	// public void verify_forgot_blank_email() throws InterruptedException {
	// String actual =
	// getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text
	// text-danger']")).getText();
	// System.out.println(actual);
	// Assert.assertEquals("Please enter the Email ID", actual);
	// }

	public void verify_forgot_validemail() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-muted']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals(
				"An email with detailed instructions on how to reset your password has been sent to *****@qwinix.io.",
				actual);
	}

	public void forgot_invalemail(String invalemail) {
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
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(0));
		getDriver().close();
		getDriver().switchTo().window(tabs2.get(1));
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();
	}

	public void verify_resetpswrd_empty() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 errorMsg form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("New Password cannot be empty", actual);
	}

	public void newpswrd_empty(String pswrd) {

		CommonUtil.waitForElement(confirm_password);
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
		new_password.clear();
		CommonUtil.waitForElement(new_password);
		new_password.sendKeys("password");
		CommonUtil.waitForElement(confirm_password);
		confirm_password.clear();
		confirm_password.sendKeys("password");
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();
	}

	public void verify_invalid_resetpswrd() {
		String actual = getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div/div[1]/small")).getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter valid password.", actual);
	}

	public void valid_resetpswrd() {
		new_password.clear();
		CommonUtil.waitForElement(new_password);
		new_password.sendKeys("Password1234");
		CommonUtil.waitForElement(confirm_password);
		confirm_password.clear();
		confirm_password.sendKeys("Password1234");
		CommonUtil.waitForElement(reset_submit);
		reset_submit.click();
	}

	public void verify_valid_resetpswrd() {
		String actual = getDriver().findElement(By.xpath("//*[@id='root']/div[1]/div/div/span[1]")).getText();
		System.out.println(actual);
		Assert.assertEquals("You have successfully reset your password.", actual);
	}

	public void blank_email_with_navigation() {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(next);
		dot_button.click();
	}

	public void invalid_email_with_dot(String invalemail) {
		hambarger_button.click();
		CommonUtil.waitForElement(login);
		login.click();
		CommonUtil.waitForElement(loginemail);
		loginemail.sendKeys(invalemail);
		CommonUtil.waitForElement(next);
		dot_button.click();
	}

	public void terms_condition() {
		CommonUtil.waitForElement(checkbox_button);
		checkbox_button.click();
		CommonUtil.waitForElement(submit);
		submit.click();
		CommonUtil.waitForElement(ok_button);
		ok_button.click();

	}

	public void verify_terms_condition() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Please Accept terms & Conditions", actual);
	}

	public void valid_with_term_condition(String valemail, String valpswrd) {
		hambarger_button.click();
		login.click();
		loginemail.sendKeys(valemail);
		next.click();
		password.sendKeys(valpswrd);
		checkbox_button.click();
		submit.click();
		ok_button.click();

	}

	public void verify_forgot_in_at_email() {
		String actual = getDriver().findElement(By.xpath("//small[@class='fontSize12 form-text text-danger']"))
				.getText();
		System.out.println(actual);
		Assert.assertEquals("Please enter the correct Email ID", actual);
	}

	public void verify_succesful_text() {
		String actual = getDriver().findElement(By.xpath("//div[@class='swal-text']")).getText();
		System.out.println(actual);
		Assert.assertEquals("Record Saved Successfully.", actual);
	}

	public void search_empty_data() throws InterruptedException {
		data_cleansing.click();
		search_text.click();
		go_button.click();
		String text = fetch_text.getText();
		System.out.println(text);

	}

	public void edit_text(String excepted) throws InterruptedException {
		search_text.sendKeys("ama");
		go_button.click();
		onMouseover();
		edit_save_button.click();
		no_name_selected(excepted);
		ok_click.click();
		onMouseover();
		edit_company_name.sendKeys("Amazon");
		option_click.click();
		edit_affiliated_name.sendKeys("kro");
		option_click.click();
		edit_save_button.click();
	}

	public void verify_number_of_records(String excepted) {
		String actual = getDriver().findElement(By.xpath("//span[@class='cna-action-text']")).getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);

	}

	public void onMouseover() {

		Actions action = new Actions(getDriver());
		action.moveToElement(
				getDriver().findElement(By.xpath("(//td[@class='align-middle orange font-weight-bold'])[1]"))).click()
				.build().perform();
		getDriver().findElement(By.xpath("(//button[@class='loginButton cursor-pointer cna-edit-btn'])[1]")).click();

	}

	public void no_name_selected(String excepted) {
		String actual = verify_text.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);

	}

	public void succesfuly_record_saved(String excepted) throws InterruptedException {
		Thread.sleep(2000);
		String actual = verify_text.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);
	}

	public void Select_all_cleansing_data_empty() {
		data_cleansing.click();
		search_text.sendKeys("ama");
		go_button.click();
		selectall_button.click();
		apply_selection.click();
	}

	public void error_msg(String excepted) {
		no_name_selected(excepted);
		ok_click.click();
	}

	public void select_all_cleansing_data() {
		data_cleansing.click();
		search_text.sendKeys("ama");
		go_button.click();
		selectall_button.click();
		edit_company_name.sendKeys("Amazon");
		option_click.click();
		edit_affiliated_name.sendKeys("kro");
		option_click.click();
		frst_checkbox.click();
		frst_checkbox.click();
		String value = value_fetch.getAttribute("value");
		System.out.println(value);
		Assert.assertEquals("Kroger", value);
		apply_selection.click();
	}

	public void succesfuly_records_saved(String excepted) throws InterruptedException {
		Thread.sleep(2000);
		String actual = inval_errmsg.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);
	}

	public void seach_lessthan_chars() {
		data_cleansing.click();
		search_text.sendKeys("am");
		go_button.click();

	}

	public void verify_tooltip_msg(String excepted) {
		String actual = fetch_text.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);

	}

	public void serach_invaldata() {
		data_cleansing.click();
		search_text.sendKeys("gfh");
		go_button.click();
	}

	public void verify_invalid_msg(String excepted) throws InterruptedException {
		Thread.sleep(2000);
		String actual = inval_errmsg.getText();
		System.out.println("Actual--->" + actual + "  Expected--->" + excepted);
		Assert.assertEquals(actual, excepted);

	}

	public void logout() {
		hambarger_button.click();
		logout.click();
	}
}