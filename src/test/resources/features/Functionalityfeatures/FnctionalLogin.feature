@Login
Feature: This feature is to test the Entaly login functionality

  Background: user able to login
    Given I am on home page

  @login_blank_email
  Scenario: trying to leave the email field as a blank
    When I leave email field as a  blank and click the next button
    Then I should get blank email error

  @invalid_email
  Scenario: trying to enter invalid email
    When I enter the invalid email id "deepika@gmail.com" and click on submit button
    Then I should get invalid email error
	
   @email_with_in
	Scenario: trying to enter email id with in extension
	  When I enter the email id "kkeshavaswamy@gmail.in" and click on submit button
	  Then I should  see the invalid error message
		
	@email_with_org
	Scenario: trying to enter email id with org extension
	  When I enter the emailid "kkeshavaswamy@gmail.org" and click on submit button
	  Then I should  see the invalid error 
	 
	@email_without_at_symbol
	Scenario: trying to enter email without @symbol
	  When I enter the email "kkeshavaswamyqwinix.io" and click on submit button
	  Then I should see the message as enter correct email id
	  
	@email_without_dot_symbol
	Scenario: trying to enter emailid without .symbol
	  When I enter  email "kkeshavaswamy@qwinixio" and click on submit button
	  Then I should see the message

	@blank_email_with_navigation
	Scenario: trying to leave the email field as a blank
	  When I leave the email field as a blank and click on dot 
	  Then I should get error message 
	  
	@invalid_with_navigation
	Scenario: trying to enter the invalid email field as a blank
		When I entered invalid email "deepika@gmail.com" and click on dot 
		Then I should see the error
		
	@email_with_navigation_in
	Scenario: trying to enter email id with in extension
	  When I enter the email id "kkeshavaswamy@gmail.in" and click on dot
	  Then I should  see the invalid  message
		
	@email_with_navigation_org
	Scenario: trying to enter email id with org extension
	  When I enter the email id "kkeshavaswamy@gmail.org" and click on dot
	  Then I should  get invalid error 
	 
	@email_without_navigation_at_symbol
	Scenario: trying to enter email without @symbol
	  When I enter the e-mail "kkeshavaswamyqwinix.io" and click on submit button
	  Then I should see the invalid  message as enter correct email id
	  
	@email_without_navigation_dot_symbol
	Scenario: trying to enter email without .symbol
	  When I enter the e mail-id "kkeshavaswamy@qwinixio" and click on submit button
	  Then I should see  error message

  @valemail_blank_password
  Scenario: trying to leave password field as blank
    When I enter valid email "kkeshavaswamy@qwinix.io"and leave the password field as a blank and click on submit
    Then I should get blank password error

	@agree_terms_condition
	Scenario: trying to click on terms and condition button
	When I enter  email "kkeshavaswamy@qwinix.io" and valid password "Password1234" and withou click on condition
	Then I should see the terms and condition error message
	

  @valemail_invalpswrd_with_two_attempts
  Scenario: trying to login with valid email and invalid password
    When I entered valid email"kkeshavaswamy@qwinix.io" and invalid password "password123" and click on submit button
    And I click on terms and condition
    Then I should see get left two attempt error
    
  @valemail_invalpswrd_with_one_attempts
  Scenario: trying to login with valid email and invalid password
    When I enter valid email"kkeshavaswamy@qwinix.io" and invalid password "password123" and click on submit button
    And I click on terms and condition button
    Then I should see get left one attempt error

  @valid_login
  Scenario: trying to login with valid credential
    When I enter valid email "kkeshavaswamy@qwinix.io" and password "Password1234" click on condition
    Then I should see the dashboard page

  @report_verify
  Scenario: trying to verify all reports loading or not
    When I enter valid email "ssampathkumar@qwinix.io" and  valid password "Password1234"
    Then I click intelligent pricing solution in dashboard and reports in report page
    Then I should see displaying of reports

  @forgotpassword_blankemail
  Scenario: trying to leave the email field as blank in reset password page
    When I leave email field as a blank in reset password page and click on submit button
    Then I should see the invalid email error

  @forgotpassword_invalemail
  Scenario: trying to enter invalid email  in reset password
    When I entered invalid email "deepika123@gmail.com" in reset password
    Then I should see the error message

	@forgotemail_with_in
	Scenario: trying to enter email id with in extension
	  When I enter the email id "kkeshavaswamy@gmail.in" and click on submit in forgot password page
	  Then I should  see the invalid  message in forgot password page
		
	@forgotemail_with_org
	Scenario: trying to enter email id with org extension
	  When I enter the email id "kkeshavaswamy@gmail.org" in forgot password page and click on submit 
	  Then I should  get invalid error in forgot password page
	 
	@forgotemail_without_navigation_at_symbol
	Scenario: trying to enter email without @symbol
	  When I enter the e-mail "kkeshavaswamyqwinix.io" in forgot password page and click on submit 
	  Then I should see the invalid  message as enter correct email id in forgot password page
	  
	@forgotemail_without_navigation_dot_symbol
	Scenario: trying to enter email without .symbol
	  When I enter the e mail-id "kkeshavaswamy@qwinixio" in forgot password page and click on submit
	  Then I should see  error message in forgot password page
	

  @forgotpassword_valemail
  Scenario: trying to reset the password
    When I click on forgot password and I entered valid email "kkeshavaswamy@qwinix.io"
   Then I should redirect to the email and reset the password
