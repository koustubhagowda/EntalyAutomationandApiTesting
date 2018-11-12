@Reset_password
Feature: As a end user
I should able to reset the password

	@resetpswrd_empty
	Scenario:trying to leave the new password and confirm password as a blank
	When I leave the new password and confirm password as a blank "" and click on submit button
	Then I should get error message as new password cannot be empty