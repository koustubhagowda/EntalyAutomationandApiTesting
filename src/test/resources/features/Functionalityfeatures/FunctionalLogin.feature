@Login
Feature: As a end user
  I should able to login into the entaly application

  Background: user able to login
    Given I am on home page

  @blank_email
  Scenario: trying to leave the email field as a blank
    When I leave email field as a  blank and click the next button
    Then I should get error "Please enter the email id"

  @invalid_email
  Scenario: trying to enter invalid email
    When I enter the invalid email id "deepika@gmail.com" and click on submit button
    Then I should get  "Email id does not exist, please enter a valid email id"

  @email_with_in
  Scenario: trying to enter email id with in extension
    When I enter the email id "kkeshavaswamy@gmail.in" and click on submit button
    Then I should  see the invalid error message "Email id does not exist, please enter a valid email id"

  @email_with_org
  Scenario: trying to enter email id with org extension
    When I enter the emailid "kkeshavaswamy@gmail.org" and click on submit button
    Then I should  see the invalid error "Email id does not exist, please enter a valid email id"

  @email_without_at_symbol
  Scenario: trying to enter email without @symbol
    When I enter the email "kkeshavaswamyqwinix.io" and click on submit button
    Then I should see the message as "Please enter the correct email id"

  @email_without_dot_symbol
  Scenario: trying to enter emailid without .symbol
    When I enter  email "kkeshavaswamy@qwinixio" and click on submit button
    Then I should see the  "Please enter the correct email id"

  @blank_email_with_navigation
  Scenario: trying to leave the email field as a blank
    When I leave the email field as a blank and click on dot
    Then I should get error message "Please enter the email id"

  @invalid_with_navigation
  Scenario: trying to enter the invalid email field as a blank
    When I entered invalid email "deepika@gmail.com" and click on dot
    Then I should get the error as "Email id does not exist, please enter a valid email id"

  @email_with_navigation_in
  Scenario: trying to enter email id with in extension
    When I enter the email id "kkeshavaswamy@gmail.in" and click on dot
    Then I should  see the invalid  message "Email id does not exist, please enter a valid email id"

  @email_with_navigation_org
  Scenario: trying to enter email id with org extension
    When I enter the emailid "kkeshavaswamy@gmail.org" and click on dot
    Then I should  get invalid error "Email id does not exist, please enter a valid email id"

  @email_without_navigation_at_symbol
  Scenario: trying to enter email without @symbol
    When I enter the e-mail "kkeshavaswamyqwinix.io" and click on submit button
    Then I should get the invalid  message as "Please enter the correct email id"

  @email_without_navigation_dot_symbol
  Scenario: trying to enter email without .symbol
    When I enter the e mail-id "kkeshavaswamy@qwinixio" and click on submit button
    Then I should see  email error message "Please enter the correct email id"

  @valemail_blank_password
  Scenario: trying to leave password field as blank
    When I enter valid email "kkeshavaswamy@qwinix.io"and leave the password field as a blank and click on submit
    Then I should get blank password error "Please enter the password"

  @agree_terms_condition
  Scenario: trying to click on terms and condition button
    When I enter  email "kkeshavaswamy@qwinix.io" and valid password "Password1234" and withou click on condition
    Then I should see the terms and condition error message "Please Accept terms & Conditions"

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

  @forgotpassword_blankemail
  Scenario: trying to leave the email field as blank in reset password page
    When I leave email field as a blank in reset password page and click on submit button
    Then I should see the invalid email error "Please enter the Email ID"

  @forgotpassword_invalemail
  Scenario: trying to enter invalid email  in reset password
    When I entered invalid email "deepika123@gmail.com" in reset password
    Then I should see the error message "Email id does not exist, please enter a valid email id"

  @forgotemail_with_in
  Scenario: trying to enter email id with in extension
    When I enter the email id "kkeshavaswamy@gmail.in" and click on submit in forgot password page
    Then I should  see the invalid  message in forgot password "Email id does not exist, please enter a valid email id"

  @forgotemail_with_org
  Scenario: trying to enter email id with org extension
    When I enter the email id "kkeshavaswamy@gmail.org" in forgot password page and click on submit
    Then I should  get invalid error in forgot password page "Email id does not exist, please enter a valid email id"

  @forgotemail_without_navigation_at_symbol
  Scenario: trying to enter email without @symbol
    When I enter the e-mail "kkeshavaswamyqwinix.io" in forgot password page and click on submit
    Then I see messge as "Please enter the correct Email ID"

  @forgotemail_without_navigation_dot_symbol
  Scenario: trying to enter email without .symbol
    When I enter the e mail-id "kkeshavaswamy@qwinixio" in forgot password page and click on submit
    Then I  see  error message "Please enter the correct Email ID"

  @forgotpassword_valemail
  Scenario: trying to reset the password
    When I click on forgot password and I entered valid email "kkeshavaswamy@qwinix.io"
    Then I should redirect to the email and reset the password
