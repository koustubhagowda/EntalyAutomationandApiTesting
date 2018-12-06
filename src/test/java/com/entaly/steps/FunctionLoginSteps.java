package com.entaly.steps;

import org.openqa.selenium.WebElement;

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

	@Then("^I should get error \"([^\"]*)\"$")
	public void i_should_get_error(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);	}	
	   

	@When("^I enter the invalid email id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_invalid_email_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should get  \"([^\"]*)\"$")
	public void i_should_get(String excepted) throws Throwable {
		 objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the email id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_email_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should  see the invalid error message \"([^\"]*)\"$")
	public void i_should_see_the_invalid_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the emailid \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_emailid_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}


	@Then("^I should  see the invalid error \"([^\"]*)\"$")
	public void i_should_see_the_invalid_error(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	@When("^I enter the email \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_email_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should see the message as \"([^\"]*)\"$")
	public void i_should_see_the_message_as(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter  email \"([^\"]*)\" and click on submit button$")
	public void i_enter_email_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email(invalemail);
	}

	@Then("^I should see the  \"([^\"]*)\"$")
	public void i_should_see_the(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I leave the email field as a blank and click on dot$")
	public void i_leave_the_email_field_as_a_blank_and_click_on_dot() throws Throwable {
	   objLS. blank_email_with_navigation();
	}

	@Then("^I should get error message \"([^\"]*)\"$")
	public void i_should_get_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	
	@When("^I entered invalid email \"([^\"]*)\" and click on dot$")
	public void i_entered_invalid_email_and_click_on_dot(String invalemail) throws Throwable {
	    objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should get the error as \"([^\"]*)\"$")
	public void i_should_get_the_error_as(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the email id \"([^\"]*)\" and click on dot$")
	public void i_enter_the_email_id_and_click_on_dot(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should  see the invalid  message \"([^\"]*)\"$")
	public void i_should_see_the_invalid_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the emailid \"([^\"]*)\" and click on dot$")
	public void i_enter_the_emailid_and_click_on_dot(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should  get invalid error \"([^\"]*)\"$")
	public void i_should_get_invalid_error(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	
	@When("^I enter the e-mail \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_e_mail_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should get the invalid  message as \"([^\"]*)\"$")
	public void i_should_get_the_invalid_message_as(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}

	@When("^I enter the e mail-id \"([^\"]*)\" and click on submit button$")
	public void i_enter_the_e_mail_id_and_click_on_submit_button(String invalemail) throws Throwable {
		objLS.invalid_email_with_dot(invalemail);
	}

	@Then("^I should see  email error message \"([^\"]*)\"$")
	public void i_should_see_email_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	
	
	
	


	@When("^I enter valid email \"([^\"]*)\"and leave the password field as a blank and click on submit$")
	public void i_enter_valid_email_and_leave_the_password_field_as_a_blank_and_click_on_submit(String email)
			throws Throwable {
		objLS.password_blank(email);
	}

	@Then("^I should get blank password error \"([^\"]*)\"$")
	public void i_should_get_blank_password_error(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter  email \"([^\"]*)\" and valid password \"([^\"]*)\" and withou click on condition$")
	public void i_enter_email_and_valid_password_and_withou_click_on_condition(String valemail, String valpswrd) throws Throwable {
	    objLS.valid_login(valemail, valpswrd);
	}

	@Then("^I should see the terms and condition error message \"([^\"]*)\"$")
	public void i_should_see_the_terms_and_condition_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
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






	@When("^I enter valid email \"([^\"]*)\" and password \"([^\"]*)\" click on condition$")
	public void i_enter_valid_email_and_password_click_on_condition(String valemail, String valpswrd) throws Throwable {
	    objLS.valid_with_term_condition(valemail, valpswrd);
	}

	@Then("^I should see the dashboard page$")
	public void i_should_see_the_dashboard_page() throws Throwable {
		objLS.dashboard_page_verify();

	}

	@When("^I leave email field as a blank in reset password page and click on submit button$")
	public void i_leave_email_field_as_a_blank_in_reset_password_page_and_click_on_submit_button() throws Throwable {
		objLS.forgotemail_blank();
	}

	@Then("^I should see the invalid email error \"([^\"]*)\"$")
	public void i_should_see_the_invalid_email_error(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}

	@When("^I entered invalid email \"([^\"]*)\" in reset password$")
	public void i_entered_invalid_email_in_reset_password(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should see the error message \"([^\"]*)\"$")
	public void i_should_see_the_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	@When("^I enter the email id \"([^\"]*)\" and click on submit in forgot password page$")
	public void i_enter_the_email_id_and_click_on_submit_in_forgot_password_page(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I should  see the invalid  message in forgot password \"([^\"]*)\"$")
	public void i_should_see_the_invalid_message_in_forgot_password(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the email id \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_email_id_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}
	
	@Then("^I should  get invalid error in forgot password page \"([^\"]*)\"$")
	public void i_should_get_invalid_error_in_forgot_password_page(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}

	
	@When("^I enter the e-mail \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_e_mail_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I see messge as \"([^\"]*)\"$")
	public void i_see_messge_as(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}
	
	@When("^I enter the e mail-id \"([^\"]*)\" in forgot password page and click on submit$")
	public void i_enter_the_e_mail_id_in_forgot_password_page_and_click_on_submit(String invalemail) throws Throwable {
		objLS.forgot_invalemail(invalemail);
	}

	@Then("^I  see  error message \"([^\"]*)\"$")
	public void i_see_error_message(String excepted) throws Throwable {
		objLS.verify__email_errors(excepted);
	}

	@When("^I click on forgot password and I entered valid email \"([^\"]*)\"$")
	public void i_click_on_forgot_password_and_I_entered_valid_email(String valemail) throws Throwable {
		objLS.forgot_email(valemail);
	}

	@Then("^I should redirect to the email and reset the password$")
	public void i_should_redirect_to_the_email_and_reset_the_password() throws Throwable {
		objLS.verify_forgot_validemail();
	}

	

//	@When("^I leave the new password field as a blank and and enter confirm password \"([^\"]*)\" and click on submit button$")
//	public void i_leave_the_new_password_field_as_a_blank_and_and_enter_confirm_password_and_click_on_submit_button(
//			String pswrd) throws Throwable {
//
//		objLS.newpswrd_empty(pswrd);
//	}
//
//	@Then("^I should see the error message as new password cannot be empty$")
//	public void i_should_see_the_error_message_as_new_password_cannot_be_empty() throws Throwable {
//		objLS.verify_resetpswrd_empty();
//	}

}
