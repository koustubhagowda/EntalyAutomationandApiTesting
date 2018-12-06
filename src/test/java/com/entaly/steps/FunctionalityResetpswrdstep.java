package com.entaly.steps;

import com.entaly.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FunctionalityResetpswrdstep {
	LoginPage objLS;
	
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
