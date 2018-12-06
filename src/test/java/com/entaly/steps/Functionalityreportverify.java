package com.entaly.steps;

import com.entaly.pages.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Functionalityreportverify {
	LoginPage objLS;
		
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
		objLS.logout();
	}
	
	
}
