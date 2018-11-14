@Login
Feature: As a end user
  I should able to login into the entaly application

  Background: user able to login
    Given I am on home page

  @blank_email
  Scenario: trying to leave the email field as a blank
    When I leave email field as a  blank and click the next button
    Then I should get blank email error

  @invalid_email
  Scenario: trying to enter invalid email
    When I enter the invalid email id "deepika@gmail.com" and click on submit button
    Then I should get invalid email error

  @valemail_blank_password
  Scenario: trying to leave password field as blank
    When I enter valid email "kkeshavaswamy@qwinix.io"and leave the password field as a blank and click on submit
    Then I should get blank password error

  @valemail_invalpswrd_with_two_attempts
  Scenario: trying to login with valid email and invalid password
    When I entered valid email"kkeshavaswamy@qwinix.io" and invalid password "password123" and click on submit button
    Then I should get left 2 attempts error
    Then I entered invalid password "123"
    Then I should see get left one attempt error

  @valid_login
  Scenario: trying to login with valid credential
    When I enter valid email "kkeshavaswamy@qwinix.io" and password "Password1234"
    Then I should see the dashboard page

  @report_verify
  Scenario: trying to verify all reports loading or not
    When I enter valid email "kkeshavaswamy@qwinix.io" and  valid password "Password1234"
    Then I click intelligent pricing solution in dashboard and reports in report page
    Then I should see displaying of reports

  @resetpassword_blankemail
  Scenario: trying to leave the email field as blank in reset password page
    When I leave email field as a blank in reset password page and click on submit button
    Then I should see the invalid email error

  @resetpassword_invalemail
  Scenario: trying to enter invalid email  in reset password
    When I entered invalid email "deepika123@gmail.com" in reset password
    Then I should see the error message

  @resetpassword_valemail
  Scenario: trying to reset the password
    When I click on forgot password and I entered valid email "kkeshavaswamy@qwinix.io"
    Then I should redirect to the email and reset the password
