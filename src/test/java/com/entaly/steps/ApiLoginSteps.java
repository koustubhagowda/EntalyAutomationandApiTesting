package com.entaly.steps;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.entaly.commonutils.FunctionalCommonUtils;
import com.entaly.pages.LoginPage;

//import com.entaly.commonutils.ApiCommonUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class ApiLoginSteps extends PageObject{
	LoginPage functionality = new LoginPage();
	FunctionalCommonUtils CommonUtil = new FunctionalCommonUtils();
	// ApiCommonUtils commonobj = new ApiCommonUtils();
	String baseuri = "http://entalyapi.eastus.cloudapp.azure.com:5375";
	public Response response;
	// String accesstoken = null;
	// int id;
	// int vid;

	@When("^I send end point with invalid BasePath that allows a user need to post invalid api data$")
	public void i_send_end_point_with_invalid_BasePath_that_allows_a_user_need_to_post_invalid_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/validateuse").post();
	}

	@Then("^It launches invalid api data and verified the message as \"([^\"]*)\"$")
	public void it_launches_invalid_api_data_and_verified_the_message_as(String notfound) throws Throwable {
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with valid BasePath that allows a user need to post invalid user key data$")
	public void i_send_end_point_with_valid_BasePath_that_allows_a_user_need_to_post_invalid_user_key_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("user", "kkeshavaswamy@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/validateuser").post();
	}

	@Then("^It launches invalid user key data and verified the message as \"([^\"]*)\"$")
	public void it_launches_invalid_user_key_data_and_verified_the_message_as(String invaliduser) throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with valid BasePath that allows a user need to post invalid user data$")
	public void i_send_end_point_with_valid_BasePath_that_allows_a_user_need_to_post_invalid_user_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshav@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/validateuser").post();
	}

	@Then("^It launches invalid user data and verified the message as \"([^\"]*)\"$")
	public void it_launches_invalid_user_data_and_verified_the_message_as(String invaliduser) throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with valid BasePath that allows a blank user need to post blank user data$")
	public void i_send_end_point_with_valid_BasePath_that_allows_a_blank_user_need_to_post_blank_user_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.baseUri(baseuri).basePath("/auth/validateuser").post();
	}

	@Then("^It launches blank user data and verified the message as \"([^\"]*)\"$")
	public void it_launches_blank_user_data_and_verified_the_message_as(String invaliduser) throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with valid BasePath that allows to post invalid data$")
	public void i_send_end_point_with_valid_BasePath_that_allows_to_post_invalid_data() throws Throwable {
		RequestSpecification request = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("username", "kkeshav@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/validateuser").post();
	}

	@Then("^It launches api data and verified the message as \"([^\"]*)\"$")
	public void it_launches_api_data_and_verified_the_message_as(String unsupported) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + unsupported);
		Assert.assertEquals(unsupported, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post validateuser api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_validateuser_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/validateuser").post();
	}

	@Then("^It launches data created successfully and verified the message as \"([^\"]*)\"$")
	public void it_launches_data_created_successfully_and_verified_the_message_as(String msg) throws Throwable {
		ResponseBody body = response.getBody();
		String usernames = response.jsonPath().getString("message");
		System.out.println("Actual--->" + usernames + "  Expected--->" + msg);
		Assert.assertEquals(msg, usernames);
	}

	@When("^I send end point with invalid BasePath that allows a user need to post before user login invalid api data$")
	public void i_send_end_point_with_invalid_BasePath_that_allows_a_user_need_to_post_before_user_login_invalid_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		json.put("password", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/aut").post();
	}

	@Then("^It launches invalid api data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_invalid_api_data_and_can_able_to_fetch_error_response(String notfound) throws Throwable {
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with BasePath that allows to post before user login blank user data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_blank_user_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("password", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches blank user data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_blank_user_data_and_can_able_to_fetch_error_response(String invaliduser) throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with BasePath that allows to post before user login blank password data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_blank_password_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches blank password data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_blank_password_data_and_can_able_to_fetch_error_response(String badcreds) throws Throwable {
		ResponseBody body = response.getBody();
		String badcredentials = response.jsonPath().getString("message");
		System.out.println("Actual--->" + badcredentials + "  Expected--->" + badcreds);
		Assert.assertEquals(badcreds, badcredentials);
	}

	@When("^I send end point with BasePath that allows to post before user login invalid user key data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_invalid_user_key_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("user", "kkeshavaswamy@qwinix.io");
		json.put("password", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches invalid user key data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_invalid_user_key_data_and_can_able_to_fetch_error_response(String invaliduser)
			throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with BasePath that allows to post before user login invalid user value data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_invalid_user_value_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshav@qwinix.io");
		json.put("password", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches invalid user value data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_invalid_user_value_data_and_can_able_to_fetch_error_response(String invaliduser)
			throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with BasePath that allows to post before user login invalid password key data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_invalid_password_key_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		json.put("pass", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches invalid password key data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_invalid_password_key_data_and_can_able_to_fetch_error_response(String badcreds)
			throws Throwable {
		ResponseBody body = response.getBody();
		String badcredentials = response.jsonPath().getString("message");
		System.out.println("Actual--->" + badcredentials + "  Expected--->" + badcreds);
		Assert.assertEquals(badcreds, badcredentials);
	}

	@When("^I send end point with BasePath that allows to post before user login invalid password value data$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_invalid_password_value_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		json.put("password", "Password");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches invalid password value data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_invalid_password_value_data_and_can_able_to_fetch_error_response(String badcreds)
			throws Throwable {
		ResponseBody body = response.getBody();
		String badcredentials = response.jsonPath().getString("message");
		System.out.println("Actual--->" + badcredentials + "  Expected--->" + badcreds);
		Assert.assertEquals(badcreds, badcredentials);
	}

	@When("^I send end point with BasePath that allows to post before user login blank body credentials$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_blank_body_credentials()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches blank body credentials data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_blank_body_credentials_data_and_can_able_to_fetch_error_response(String invaliduser)
			throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with BasePath that allows to post before user login with blank header$")
	public void i_send_end_point_with_BasePath_that_allows_to_post_before_user_login_with_blank_header()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		json.put("password", "Password");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
	}

	@Then("^It launches blank header data and can able to fetch error response \"([^\"]*)\"$")
	public void it_launches_blank_header_data_and_can_able_to_fetch_error_response(String unsupported)
			throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + unsupported);
		Assert.assertEquals(unsupported, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post before user login api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_before_user_login_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "kkeshavaswamy@qwinix.io");
		json.put("password", "Password1234");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/auth").post();
		// System.out.println(response.asString());
	}

	@Then("^It launches data created successfully and can able to fetch access token$")
	public void it_launches_data_created_successfully_and_can_able_to_fetch_access_token() throws Throwable {
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		String accesstoken = response.jsonPath().getString("token");
		System.out.println("Accesstoken is--->" + accesstoken);
		Serenity.setSessionVariable("accessToken").to(accesstoken);
	}

	@When("^I send end point with BasePath that allows a user need to get invalid user login api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_get_invalid_user_login_api()
			throws Throwable {
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/user/currentuse").get();
	}

	@Then("^the task launch data retrieved and verified with response error \"([^\"]*)\"$")
	public void the_task_launch_data_retrieved_and_verified_with_response_error(String notfound) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with BasePath that allows to get empty accesstoken credential$")
	public void i_send_end_point_with_BasePath_that_allows_to_get_empty_accesstoken_credential() throws Throwable {
		RequestSpecification request = RestAssured.given();
		response = request.baseUri(baseuri).basePath("/user/currentuser").get();
	}

	@Then("^the task launch data retrieved and verified with error response \"([^\"]*)\"$")
	public void the_task_launch_data_retrieved_and_verified_with_error_response(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows to get invalid accesstoken pattren$")
	public void i_send_end_point_with_BasePath_that_allows_to_get_invalid_accesstoken_pattren() throws Throwable {
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "" + accessToken);
		response = request.baseUri(baseuri).basePath("/user/currentuser").get();
	}

	@Then("^the task launch data and verified with error response \"([^\"]*)\"$")
	public void the_task_launch_data_and_verified_with_error_response(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to get after user login api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_get_after_user_login_api_data()
			throws Throwable {
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/user/currentuser").get();
		// System.out.println(response.asString());
	}

	@Then("^the task launch data retrieved successfully and verified with application data$")
	public void the_task_launch_data_retrieved_successfully_and_verified_with_application_data() throws Throwable {
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		String name = response.jsonPath().getString("applicationData.name");
		System.out.println(name);
		String id = response.jsonPath().getString("applicationData.applicationId[0]");
		System.out.println(id);
		Serenity.setSessionVariable("ID").to(id);
	}

	@When("^I send end point with BasePath that allows a user to get invalid reports api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_get_invalid_reports_api() throws Throwable {
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/reports/").get();
	}

	@Then("^the task launch data fetched successfully and verified with response error \"([^\"]*)\"$")
	public void the_task_launch_data_fetched_successfully_and_verified_with_response_error(String notfound)
			throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with BasePath that allows a user to get empty accesstoken credential$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_get_empty_accesstoken_credential()
			throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		RequestSpecification request = RestAssured.given();
		response = request.baseUri(baseuri).basePath("/powerbi/reports/" + ID).get();
	}

	@Then("^the task launch data fetched and verified with response error \"([^\"]*)\"$")
	public void the_task_launch_data_fetched_and_verified_with_response_error(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows a user to get invalid access token pattern$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_get_invalid_access_token_pattern()
			throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer" + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/reports/" + ID).get();
	}

	@Then("^the task launch data and verified with response error \"([^\"]*)\"$")
	public void the_task_launch_data_and_verified_with_response_error(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows a user to get the reports data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_get_the_reports_data() throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/reports/" + ID).get();
	}

	@Then("^the task launch data fetched successfully and verified with name of reports$")
	public void the_task_launch_data_fetched_successfully_and_verified_with_name_of_reports() throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		String vname = response.jsonPath().getString("value.name");
		System.out.println(vname);
		String vid = response.jsonPath().getString("value.id[0]");
		System.out.println(vid);
		Serenity.setSessionVariable("VID").to(vid);
		String groupid = response.jsonPath().getString("groupId");
		Serenity.setSessionVariable("GID").to(groupid);
		String appname = response.jsonPath().getString("applicationName");
		Serenity.setSessionVariable("APPNAME").to(appname);
	}

	@When("^I send end point with BasePath that allows powerbi to get invalid individual api report data$")
	public void i_send_end_point_with_BasePath_that_allows_powerbi_to_get_invalid_individual_api_report_data()
			throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String VID = Serenity.sessionVariableCalled("VID").toString();
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/embeddedtoken/").get();
	}

	@Then("^the launch data retrieved and verified with response error \"([^\"]*)\"$")
	public void the_launch_data_retrieved_and_verified_with_response_error(String notfound) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with BasePath that allows powerbi to get empty accesstoken credential$")
	public void i_send_end_point_with_BasePath_that_allows_powerbi_to_get_empty_accesstoken_credential()
			throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String VID = Serenity.sessionVariableCalled("VID").toString();
		RequestSpecification request = RestAssured.given();
		response = request.baseUri(baseuri).basePath("/powerbi/embeddedtoken/" + ID + "/" + VID).get();
	}

	@Then("^the launch data retrieved and verified with error response \"([^\"]*)\"$")
	public void the_launch_data_retrieved_and_verified_with_error_response(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows powerbi to get invalid accesstoken pattern$")
	public void i_send_end_point_with_BasePath_that_allows_powerbi_to_get_invalid_accesstoken_pattern()
			throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String VID = Serenity.sessionVariableCalled("VID").toString();
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", " " + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/embeddedtoken/" + ID + "/" + VID).get();
	}

	@Then("^the launched data retrieved and verified with response error \"([^\"]*)\"$")
	public void the_launched_data_retrieved_and_verified_with_response_error(String Forbdn) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + Forbdn);
		Assert.assertEquals(Forbdn, body.asString());
	}

	@When("^I send end point with BasePath that allows powerbi to get individual report data$")
	public void i_send_end_point_with_BasePath_that_allows_powerbi_to_get_individual_report_data() throws Throwable {
		String ID = Serenity.sessionVariableCalled("ID").toString();
		String VID = Serenity.sessionVariableCalled("VID").toString();
		String accessToken = Serenity.sessionVariableCalled("accessToken").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + accessToken);
		response = request.baseUri(baseuri).basePath("/powerbi/embeddedtoken/" + ID + "/" + VID).get();
		// System.out.println(response.asString());
	}

	@Then("^the report launch data retrieved successfully and verified with response body$")
	public void the_report_launch_data_retrieved_successfully_and_verified_with_response_body() throws Throwable {
		String GID = Serenity.sessionVariableCalled("GID").toString();
		String APPNAME = Serenity.sessionVariableCalled("APPNAME").toString();
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		String gid = response.jsonPath().getString("groupId");
		String applicationname = response.jsonPath().getString("applicationName");
		System.out.println("Current api group id is--->" + gid + "  Previous api group id is--->" + GID);
		Assert.assertEquals(GID, gid);
		System.out.println("Current api appname is--->" + applicationname + "  Previous api app mane is--->" + APPNAME);
		Assert.assertEquals(APPNAME, applicationname);
	}

	@When("^I send end point with BasePath that allows a user need to post invalid forgot password api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_invalid_forgot_password_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "kkeshavaswamy@qwinix.io");
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/f").post();
	}

	@Then("^It launches successfully and verifies a error response as \"([^\"]*)\"$")
	public void it_launches_successfully_and_verifies_a_error_response_as(String notfound) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + notfound);
		Assert.assertEquals(notfound, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post blank email credential api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_blank_email_credential_api()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches successfully and verified error response as \"([^\"]*)\"$")
	public void it_launches_successfully_and_verified_error_response_as(String BadRequest) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + BadRequest);
		Assert.assertEquals(BadRequest, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post blank reset password credential api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_blank_reset_password_credential_api()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "kkeshavaswamy@qwinix.io");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches successfully and verified response error as \"([^\"]*)\"$")
	public void it_launches_successfully_and_verified_response_error_as(String BadRequest) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + BadRequest);
		Assert.assertEquals(BadRequest, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post with invalid email key$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_with_invalid_email_key()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("emal", "kkeshavaswamy@qwinix.io");
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches successfully and verified with response error \"([^\"]*)\"$")
	public void it_launches_successfully_and_verified_with_response_error(String BadRequest) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + BadRequest);
		Assert.assertEquals(BadRequest, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post with invalid email value$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_with_invalid_email_value()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "kkeshav@qwinix.io");
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches successfully and verified with response as \"([^\"]*)\"$")
	public void it_launches_successfully_and_verified_with_response_as(String invaliduser) throws Throwable {
		ResponseBody body = response.getBody();
		String notauser = response.jsonPath().getString("message");
		System.out.println("Actual--->" + notauser + "  Expected--->" + invaliduser);
		Assert.assertEquals(invaliduser, notauser);
	}

	@When("^I send end point with BasePath that allows a user need to post with invalid reset password link key$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_with_invalid_reset_password_link_key()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "kkeshavaswamy@qwinix.io");
		json.put("resetPasswordLin", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches successfully and verified with error response \"([^\"]*)\"$")
	public void it_launches_successfully_and_verified_with_error_response(String BadRequest) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + BadRequest);
		Assert.assertEquals(BadRequest, body.asString());
	}

	@When("^I send end point with BasePath that allows a user to post with blank header of forgot password api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_post_with_blank_header_of_forgot_password_api()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("email", "kkeshavaswamy@qwinix.io");
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launched successfully and verified with error response \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_with_error_response(String unsupported) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + unsupported);
		Assert.assertEquals(unsupported, body.asString());
	}

	@When("^I send end point with BasePath that allows a user to post with blank body of forgot password api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_to_post_with_blank_body_of_forgot_password_api()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launched successfully and verifies with error response \"([^\"]*)\"$")
	public void it_launched_successfully_and_verifies_with_error_response(String BadRequest) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Actual--->" + body.asString() + "  Expected--->" + BadRequest);
		Assert.assertEquals(BadRequest, body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to post forgot password api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_post_forgot_password_api_data()
			throws Throwable {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("email", "kkeshavaswamy@qwinix.io");
		json.put("resetPasswordLink", "http%3A%2F%2Fentalyapi.eastus.cloudapp.azure.com%3A4375%2Frp");
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/fp").post();
	}

	@Then("^It launches data created successfully and verified the status code as '(\\d+)'$")
	public void it_launches_data_created_successfully_and_verified_the_status_code_as(int code) throws Throwable {
		ResponseBody body = response.getBody();
		// System.out.println("Response Body is: " + body.asString());
		String statuscode = response.jsonPath().getString("status");
		int scode = Integer.parseInt(statuscode);
		System.out.println("Actual--->" + scode + "  Expected--->" + code);
		Assert.assertEquals(code, scode);
	}
	
	@When("^I get the access token from email$")
	public void i_get_the_access_token_from_email() throws Throwable {
		getDriver().manage().window().maximize();
		getDriver().get("https://accounts.google.com");// here mention mail id
														// url
		functionality.gmail_email.sendKeys("kkeshavaswamy@qwinix.io");
		CommonUtil.waitForElement(functionality.gmail_next);
		functionality.gmail_next.click();
		CommonUtil.waitForElement(functionality.gmail_password);
		functionality.gmail_password.sendKeys("keshav1994,");
		CommonUtil.waitForElement(functionality.gmail_next);
		functionality.gmail_next.click();
		functionality.gmail_button.click();
//		CommonUtil.waitForElement(gmail_frst_div);
		CommonUtil.waitForPageLoaded();
		functionality.gmail_frst_div.click();
		WebElement element = getDriver().findElement(By.xpath("//center[3]/a"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		CommonUtil.waitForElement(functionality.reset_link);
		String token = functionality.reset_link.getText();
		System.out.println(token);
		String Code = getDriver().findElement(By.xpath("//center[3]/a")).getText();
		String[] parts = Code.split("token=");
		System.out.println(parts);
		String access_token = parts[1];
		parts = access_token.split("&email=kkeshavaswamy@qwinix.io");
		access_token = parts[0];
		System.out.println(access_token);
		Serenity.setSessionVariable("Token").to(access_token);
	}
	
	@When("^I send end point with BasePath that allows a user need to put invalid reset password api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_invalid_reset_password_api_data() throws Throwable {
		String Token = Serenity.sessionVariableCalled("Token").toString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("password", "Password1234");
		json.put("token", Token);
		request.body(json.toJSONString());
		response = request.baseUri(baseuri).basePath("/auth/rp").put();
		
	}

	@Then("^It launched successfully and verified a error response as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_a_error_response_as(String arg1) throws Throwable {
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
	}

	@When("^I send end point with BasePath that allows a user need to put blank password credential api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_blank_password_credential_api() throws Throwable {
	    
	}

	@Then("^It launched successfully and verified error response as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_error_response_as(String arg1) throws Throwable {
	    
	}

	@When("^I send end point with BasePath that allows a user need to put blank token credential api$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_blank_token_credential_api() throws Throwable {
	    
	}

	@Then("^It launched successfully and verified response error as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_response_error_as(String arg1) throws Throwable {
	    
	}

	@When("^I send end point with BasePath that allows a user need to put with invalid password key$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_with_invalid_password_key() throws Throwable {
	    
	}

	@Then("^It launched successfully and verified with response error as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_with_response_error_as(String arg1) throws Throwable {
	    
	}

	@When("^I send end point with BasePath that allows a user need to put with invalid token key$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_with_invalid_token_key() throws Throwable {
	    
	}

	@Then("^It launched successfully and verified with response as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_with_response_as(String arg1) throws Throwable {
	   
	}

	@When("^I send end point with BasePath that allows a user need to put with invalid token value$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_with_invalid_token_value() throws Throwable {
	    
	}

	@Then("^It launched successfully and verified with response error message as \"([^\"]*)\"$")
	public void it_launched_successfully_and_verified_with_response_error_message_as(String arg1) throws Throwable {
	    
	}

	@When("^I send end point with BasePath that allows a user need to put reset password api data$")
	public void i_send_end_point_with_BasePath_that_allows_a_user_need_to_put_reset_password_api_data() throws Throwable {
	    
	}

	@Then("^It launched data created successfully and verified the response status code as '(\\d+)'$")
	public void it_launched_data_created_successfully_and_verified_the_response_status_code_as(int arg1) throws Throwable {
	    
	}

}