//package com.entaly.steps;
//
//import org.openqa.selenium.WebDriver;
//
//import com.entaly.commonutils.FunctionalCommonUtils;
//import com.entaly.pages.LoginPage;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import net.serenitybdd.core.Serenity;
//import net.serenitybdd.core.annotations.findby.By;
//
//public class FunctionalDatacleansingSteps {
//	LoginPage objLP = new LoginPage();
//	FunctionalCommonUtils commonUtil;
//	public static WebDriver driver;
//	
//	@Given("^Iam on home page$")
//	public void iam_on_home_page() throws Throwable {
//		String Url = Serenity.sessionVariableCalled("url").toString();
//		System.out.println(Url);
//		commonUtil.openUrl(Url);
//	}
//	
//	@When("^I enter  email \"([^\"]*)\" and   password \"([^\"]*)\"$")
//	public void i_enter_email_and_password(String valemail, String valpswrd) throws Throwable {
//		objLP.valid_login(valemail,valpswrd);
//	}
//
//	@Then("^I click data cleansing in dashboard and click on go button$")
//	public void i_click_data_cleansing_in_dashboard_and_click_on_go_button() throws Throwable {
//		objLP.search_empty_data();
//		
//		
//	}
//	
//	@Then("^I should see the \"([^\"]*)\"$")
//	public void i_should_see_the(String excepted) throws Throwable {
//		objLP.edit_text(excepted);
//	}
//
//	@Then("^I should see the no of records \"([^\"]*)\"$")
//	public void i_should_see_the_no_of_records(String excepted) throws Throwable {
//		objLP.verify_number_of_records(excepted);
//		
//	}
//	
//	@Then("^I should see \"([^\"]*)\"$")
//	public void i_should_see(String excepted) throws Throwable {
//		objLP.succesfuly_record_saved(excepted);
//	}
//	
//	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void i_enter_and(String valemail, String valpswrd) throws Throwable {
//	    objLP.valid_login(valemail, valpswrd);
//	}
//
//	@When("^I enter less than three chars in serach filed$")
//	public void i_enter_less_than_three_chars_in_serach_filed() throws Throwable {
//	    objLP.seach_lessthan_chars();
//	}
//
//	@Then("^I should get error as \"([^\"]*)\"$")
//	public void i_should_get_error_as(String excepted) throws Throwable {
//	    objLP. verify_tooltip_msg(excepted);
//	}
//	@When("^I enter email \"([^\"]*)\" and \"([^\"]*)\"$")
//	public void i_enter_email_and(String valemail, String valpswrd) throws Throwable {
//		objLP.valid_login(valemail, valpswrd);
//	}
//
//	@When("^I enter invalid data in search field$")
//	public void i_enter_invalid_data_in_search_field() throws Throwable {
//	   objLP.serach_invaldata();
//	}
//
//	@Then("^I should get \"([^\"]*)\"$")
//	public void i_should_get(String excepted) throws Throwable {
//	   objLP.verify_invalid_msg(excepted);
//	}
//	
//	
//
//
//	
//	@When("^I enter valid \"([^\"]*)\" and password \"([^\"]*)\"$")
//	public void i_enter_valid_and_password(String valemail, String valpswrd) throws Throwable {
//	    objLP.valid_login(valemail, valpswrd);
//	}
//	@When("^I click on select all and apply selection button$")
//	public void i_click_on_select_all_and_apply_selection_button() throws Throwable {
//	    objLP.Select_all_cleansing_data_empty();
//	}
//
//	@Then("^I should see the error \"([^\"]*)\"$")
//	public void i_should_see_the_error(String excepted) throws Throwable {
//	    objLP.error_msg(excepted);
//	    objLP.select_all_cleansing_data();
//	    
//	}
//	@When("^I enter valid email \"([^\"]*)\" and valid password \"([^\"]*)\"$")
//	public void i_enter_valid_email_and_valid_password(String valemail, String valpswrd) throws Throwable {
//		objLP.valid_login(valemail, valpswrd);
//	}
//
//	@When("^I click select all and click on apply selection$")
//	public void i_click_select_all_and_click_on_apply_selection() throws Throwable {
//		 objLP.select_all_cleansing_data();
//	}
//
//	@Then("^I should see the message \"([^\"]*)\"$")
//	public void i_should_see_the_message(String excepted) throws Throwable {
//		objLP.succesfuly_record_saved(excepted);
//	}
//
//	@When("^I select all checkbox and enter text again deselect the checkbox click on applyselection$")
//	public void i_select_all_checkbox_and_enter_text_again_deselect_the_checkbox_click_on_applyselection() throws Throwable {
//	    
//	}
//
//	@Then("^I should see the text change in data cleansing page$")
//	public void i_should_see_the_text_change_in_data_cleansing_page() throws Throwable {
//	   
//	}
//	
//	
//	
//
//
//	
//}
