package com.entaly.steps;

import com.entaly.commonutils.FunctionalCommonUtils;
import com.entaly.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;

public class FunctionLoginSteps {
	LoginPage objLS;
	FunctionalCommonUtils commonUtil;
	
	
	@Given("^I am on home page$")
	public void i_am_on_home_page() throws Throwable {
		String Url = Serenity.sessionVariableCalled("url").toString();
		System.out.println(Url);
		commonUtil.openUrl(Url);
	}

	@When("^I leave email field as a  blank and click the next button$")
	public void i_leave_email_field_as_a_blank_and_click_the_next_button() throws Throwable {
		objLS.loginblank();
	}

	@Then("^I should get blank email error$")
	public void i_should_get_blank_email_error() throws Throwable {
		objLS.loginblank();
	}
	   

	@When("^I enter the invalid email id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_invalid_email_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should get invalid email error$")
	public void i_should_get_invalid_email_error() throws Throwable {
		objLS.verify_invalid_email();

	}
	
	@When("^I enter the email id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_email_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should  see the invalid error message$")
	public void i_should_see_the_invalid_error_message() throws Throwable {
		objLS.verify_invalid_email();
	}
	
	@When("^I enter the emailid \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_emailid_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should  see the invalid error$")
	public void i_should_see_the_invalid_error() throws Throwable {
		objLS.verify_invalid_email();
	}
	@When("^I enter the email \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_email_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should see the message as enter correct email id$")
	public void i_should_see_the_message_as_enter_correct_email_id() throws Throwable {
	   objLS.verify_at_in_invalemail();
	}
	
	@When("^I enter  email \"([^\"]*)\" and click on submit button$")
	public void i_enter_email_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should see the message$")
	public void i_should_see_the_message() throws Throwable {
	    objLS.verify_at_in_invalemail();
	}
	
	@When("^I leave the email field as a blank and click on dot$")
	public void i_leave_the_email_field_as_a_blank_and_click_on_dot() throws Throwable {
	   objLS. blank_email_with_navigation();
	}

	@Then("^I should get error message$")
	public void i_should_get_error_message() throws Throwable {
		objLS.verify_blank_email();
	}
	@When("^I entered invalid email \"([^\"]*)\" and click on dot$")
	public void i_entered_invalid_email_and_click_on_dot(String invalemail) throws Throwable {
	    objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should see the error$")
	public void i_should_see_the_error() throws Throwable {
	    objLS.verify_invalid_email();
	}
	@When("^I enter the email id \"([^\"]*)\" and click on dot$")
	public void i_enter_the_email_id_and_click_on_dot(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should  see the invalid  message$")
	public void i_should_see_the_invalid_message() throws Throwable {
		objLS.verify_invalid_email();
	}
	@When("^I enter the e-mail \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_e_mail_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should see the invalid  message as enter correct email id$")
	public void i_should_see_the_invalid_message_as_enter_correct_email_id() throws Throwable {
		objLS.verify_at_in_invalemail();
	}
	
	@When("^I enter the e mail-id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_e_mail_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should see  error message$")
	public void i_should_see_error_message() throws Throwable {
		objLS.verify_at_in_invalemail();
	}
	
	
	
	
	


	@When("^I enter valid email \"([^\"]*)\"and leave the password field as a blank and click on submit$")
	public void i_enter_valid_email_and_leave_the_password_field_as_a_blank_and_click_on_submit(String email)
			throws Throwable {
		objLS.password_blank(email);
	}

	@Then("^I should get blank password error$")
	public void i_should_get_blank_password_error() throws Throwable {
		objLS.verify_blank_password();

	}
	
	@When("^I enter  email \"([^\"]*)\" and valid password \"([^\"]*)\" and withou click on condition$")
	public void i_enter_email_and_valid_password_and_withou_click_on_condition(String valemail, String valpswrd) throws Throwable {
	    objLS.valid_login(valemail, valpswrd);
	}

	@Then("^I should see the terms and condition error message$")
	public void i_should_see_the_terms_and_condition_error_message() throws Throwable {
	    objLS.verify_terms_condition();
	}
	
	@When("^I entered valid email\"([^\"]*)\" and invalid password \"([^\"]*)\" and click on submit button$")
	public void i_entered_valid_email_and_invalid_password_and_click_on_submit_button(String valemail, String invalpswrd) throws Throwable {
		objLS.valemail_with_two_attempts(valemail, invalpswrd);
	}

	@When("^I click on terms and condition$")
	public void i_click_on_terms_and_condition() throws Throwable {
	    objLS.terms_condition();
	}

	@Then("^I should see get left two attempt error$")
	public void i_should_see_get_left_two_attempt_error() throws Throwable {
		objLS.verify_two_attempt_text();
	}
	
	@When("^I enter valid email\"([^\"]*)\" and invalid password \"([^\"]*)\" and click on submit button$")
	public void i_enter_valid_email_and_invalid_password_and_click_on_submit_button(String valemail, String invalpswrd) throws Throwable {
		objLS.valemail_with_two_attempts(valemail, invalpswrd);
	}

	@When("^I click on terms and condition button$")
	public void i_click_on_terms_and_condition_button() throws Throwable {
		objLS.terms_condition();
	}

	@Then("^I should see get left one attempt error$")
	public void i_should_see_get_left_one_attempt_error() throws Throwable {
		objLS.verify_one_attempt_text();
	}





//	@When("^I entered valid email\"([^\"]*)\" and invalid password \"([^\"]*)\" and click on submit button$")
//	public void i_entered_valid_email_and_invalid_password_and_click_on_submit_button(String valemail,
//			String invalpswrd) throws Throwable {
//		objLS.valemail_with_two_attempts(valemail, invalpswrd);
//	}
//
//	@Then("^I should get left (\\d+) attempts error$")
//	public void i_should_get_left_attempts_error(int arg1) throws Throwable {
//		objLS.verify_two_attempt_text();
//	}
//
//	@Then("^I entered invalid password \"([^\"]*)\"$")
//	public void i_enterd_invalid_password(String invalpswrd) throws Throwable {
//		objLS.invalid_password(invalpswrd);
//	}
//
//	@Then("^I should see get left one attempt error$")
//	public void i_should_see_get_left_one_attempt_error() throws Throwable {
//		objLS.verify_one_attempt_text();
//	}

	@When("^I enter valid email \"([^\"]*)\" and password \"([^\"]*)\" click on condition$")
	public void i_enter_valid_email_and_password_click_on_condition(String valemail, String valpswrd) throws Throwable {
	    objLS.valid_with_term_condition(valemail, valpswrd);
	}

	@Then("^I should see the dashboard page$")
	public void i_should_see_the_dashboard_page() throws Throwable {
		objLS.dashboard_page_verify();

	}

	@When("^I enter valid email \"([^\"]*)\" and  valid password \"([^\"]*)\"$")
	public void i_enter_valid_email_and_valid_password(String valemail, String valpswrd) throws Throwable {
		objLS.valid_login(valemail, valpswrd);
	}

	@Then("^I click intelligent pricing solution in dashboard and reports in report page$")
	public void i_click_intelligent_pricing_solution_in_dashboard_and_reports_in_report_page() throws Throwable {
		objLS.dasboard_page();
	}

	@Then("^I should see displaying of reports$")
	public void i_should_see_displaying_of_reports() throws Throwable {
		objLS.report_verify();
	}

	@When("^I entered valid email \"([^\"]*)\" and inavlid password \"([^\"]*)\"$")
	public void i_entered_valid_email_and_inavlid_password(String valemail, String invalpswrd) throws Throwable {
		objLS.valemail_with_two_attempts(valemail, invalpswrd);
	}

	@Then("^I should get the two attempts error message$")
	public void i_should_get_the_two_attempts_error_message() throws Throwable {
		objLS.verify_two_attempt_text();
	}

	@Then("^I entered in valid password \"([^\"]*)\"$")
	public void i_entered_invalid_password(String invalpswrd) throws Throwable {
		objLS.invalid_password(invalpswrd);
	}

	@Then("^I should get the one attempts error message$")
	public void i_should_get_the_one_attempts_error_message() throws Throwable {
		objLS.verify_one_attempt_text();
	}

	@Then("^I enter again invalid password \"([^\"]*)\"$")
	public void i_entered_again_invalid_password(String invalpswrd) throws Throwable {
		objLS.invalid_password(invalpswrd);
	}

	@Then("^I should get account locked error message$")
	public void i_should_get_account_locked_error_message() throws Throwable {
		objLS.verify_account_locked_text();
	}

	@When("^I leave email field as a blank in reset password page and click on submit button$")
	public void i_leave_email_field_as_a_blank_in_reset_password_page_and_click_on_submit_button() throws Throwable {
		objLS.forgotemail_blank();
	}

	@Then("^I should see the invalid email error$")
	public void i_should_see_the_invalid_email_error() throws Throwable {
		objLS.verify_forgot_blank_email();
	}

	@When("^I entered invalid email \"([^\"]*)\" in reset password$")
	public void i_entered_invalid_email_in_reset_password(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should see the error message$")
	public void i_should_see_the_error_message() throws Throwable {
		objLS.verify_invalid_email();
	}
	@When("^I enter the email id \"([^\"]*)\" and click on submit in forgot password page$")
	public void i_enter_the_email_id_and_click_on_submit_in_forgot_password_page(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should  see the invalid  message in forgot password page$")
	public void i_should_see_the_invalid_message_in_forgot_password_page() throws Throwable {
		objLS.verify_invalid_email();
	}
	
	@When("^I enter the email id \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_email_id_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should  get invalid error in forgot password page$")
	public void i_should_get_invalid_error_in_forgot_password_page() throws Throwable {
		objLS.verify_invalid_email();
	}
	@When("^I enter the e-mail \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_e_mail_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should see the invalid  message as enter correct email id in forgot password page$")
	public void i_should_see_the_invalid_message_as_enter_correct_email_id_in_forgot_password_page() throws Throwable {
	    objLS.verify_forgot_in_at_email();
	}
	
	@When("^I enter the e mail-id \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_e_mail_id_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should see  error message in forgot password page$")
	public void i_should_see_error_message_in_forgot_password_page() throws Throwable {
		objLS.verify_forgot_in_at_email();
	}
	
	
	
	
	
	
	
	

	@When("^I click on forgot password and I entered valid email \"([^\"]*)\"$")
	public void i_click_on_forgot_password_and_I_entered_valid_email(String valemail) throws Throwable {
		objLS.forgot_email(valemail);
	}

	@Then("^I should redirect to the email and reset the password$")
	public void i_should_redirect_to_the_email_and_reset_the_password() throws Throwable {
		objLS.verify_forgot_validemail();
	}

	@When("^I leave the new password and confirm password as a blank \"([^\"]*)\" and click on submit button$")
	public void i_leave_the_new_password_and_confirm_password_as_a_blank_and_click_on_submit_button(String pswrd)
			throws Throwable {
		objLS.navigate_email();
		objLS.rsetpswrd_empty();
		objLS.verify_resetpswrd_empty();
		objLS.newpswrd_empty(pswrd);
		objLS.verify_resetpswrd_empty();
		objLS.confirm_pswrd_empty();
		objLS.verify_confirm_empty_pswrd();
		objLS.pswrd_mismatch();
		objLS.verify_pswrd_mismatch();
		objLS.invalid_resetpswrd();
		objLS.verify_invalid_resetpswrd();

	}

	@Then("^I should get error message as new password cannot be empty$")
	public void i_should_get_error_message_as_new_password_cannot_be_empty() throws Throwable {
		objLS.valid_resetpswrd();
		objLS.verify_valid_resetpswrd();
	}

}
