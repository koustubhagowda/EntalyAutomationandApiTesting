@Entaly_api_launches
Feature: This feature is to test the Entaly API Launch Services

	@Post_user_invalid_api
	Scenario: This scenario is to post the data related to invalid api of user validation
    When I send end point with invalid BasePath that allows a user need to post invalid api data
    Then It launches invalid api data and verified the message as "Not Found"
	
	@Post_invaliduserkey_api
	Scenario: This scenario is to post the data related to invalid user key of valid api
    When I send end point with valid BasePath that allows a user need to post invalid user key data
    Then It launches invalid user key data and verified the message as "User Not found"
	
	@Post_invaliduser_api
	Scenario: This scenario is to post the data related to invalid user of valid api
    When I send end point with valid BasePath that allows a user need to post invalid user data
    Then It launches invalid user data and verified the message as "User Not found"
	
	@Post_invaliduserdata_api
	Scenario: This scenario is to post the data related to blank user of valid api
    When I send end point with valid BasePath that allows a blank user need to post blank user data
    Then It launches blank user data and verified the message as "User Not found"
	
	@Post_invalid_api_header_data
	Scenario: This scenario is to post the invalid data related to valid api
    When I send end point with valid BasePath that allows to post invalid data
    Then It launches api data and verified the message as "Unsupported Media Type"
	
	@Post_vilidateuser_api
	Scenario: This scenario is to post the data related to validate user
    When I send end point with BasePath that allows a user need to post validateuser api data
    Then It launches data created successfully and verified the message as "Success"

  @Post_beforelogin_invalid_api
  Scenario: This scenario is to post the data related to before user login invalid api
    When I send end point with invalid BasePath that allows a user need to post before user login invalid api data
    Then It launches invalid api data and can able to fetch error response "Not Found"
  
  @Post_beforelogin_blank_user_data
  Scenario: This scenario is to post the data related to before user login with blank user data
    When I send end point with BasePath that allows to post before user login blank user data
    Then It launches blank user data and can able to fetch error response "user not found"
  
  @Post_beforelogin_blank_password_data
  Scenario: This scenario is to post the data related to before user login with blank password data
    When I send end point with BasePath that allows to post before user login blank password data
    Then It launches blank password data and can able to fetch error response "Bad credentials"
  
  @Post_beforelogin_invalid_userkey_api
  Scenario: This scenario is to post the data related to before user login with invalid user key
    When I send end point with BasePath that allows to post before user login invalid user key data
    Then It launches invalid user key data and can able to fetch error response "user not found"
  
  @Post_beforelogin_invalid_uservalue_api
  Scenario: This scenario is to post the data related to before user login with invalid user value
    When I send end point with BasePath that allows to post before user login invalid user value data
    Then It launches invalid user value data and can able to fetch error response "user not found"
  
  @Post_beforelogin_with_blank_header_api
  Scenario: This scenario is to post the data related to before user login with blank header
    When I send end point with BasePath that allows to post before user login with blank header
    Then It launches blank header data and can able to fetch error response "Unsupported Media Type"
  
  @Post_beforelogin_api
  Scenario: This scenario is to post the data related to before user login
    When I send end point with BasePath that allows a user need to post before user login api data
    Then It launches data created successfully and can able to fetch access token
	
	@Post_beforelogin_with_blank_body_api
  Scenario: This scenario is to post the data related to before user login with blank body credentials
    When I send end point with BasePath that allows to post before user login blank body credentials
    Then It launches blank body credentials data and can able to fetch error response "user not found"
    
  @Post_beforelogin_invalid_passwordkey_api
  Scenario: This scenario is to post the data related to before user login with invalid password key
    When I send end point with BasePath that allows to post before user login invalid password key data
    Then It launches invalid password key data and can able to fetch error response "Bad credentials"
  
  @Post_beforelogin_invalid_passwordvalue_api
  Scenario: This scenario is to post the data related to before user login with invalid password value
    When I send end point with BasePath that allows to post before user login invalid password value data
    Then It launches invalid password value data and can able to fetch error response "Bad credentials"
  
  @Get_afterlogin_invalid_api
  Scenario: This scenario is to get the data related to after user login with invalid api
   	When I send end point with BasePath that allows a user need to get invalid user login api
   	Then the task launch data retrieved and verified with response error "Not Found"
  
  @Get_afterlogin_empty_accesstoken_api
  Scenario: This scenario is to get the data related with empty accesstoken credential
   	When I send end point with BasePath that allows to get empty accesstoken credential
   	Then the task launch data retrieved and verified with error response "Forbidden"
  
  @Get_afterlogin_invalid_accesstoken_pattern_api
  Scenario: This scenario is to get the data related with invalid accesstoken pattern
   	When I send end point with BasePath that allows to get invalid accesstoken pattren
   	Then the task launch data and verified with error response "Forbidden"
  
  @Get_afterlogin_api
  Scenario: This scenario is to get the data related to after user login
   	When I send end point with BasePath that allows a user need to get after user login api data
   	Then the task launch data retrieved successfully and verified with application data

  @Get_powerbi_reports_invalid_api
  Scenario: This scenario is to get the data related to invalid api of powerbi reports
		When I send end point with BasePath that allows a user to get invalid reports api
   	Then the task launch data fetched successfully and verified with response error "Not Found"
  
  @Get_powerbi_reports_empty_accesstoken_api
  Scenario: This scenario is to get the data related to empty access token api of powerbi reports
		When I send end point with BasePath that allows a user to get empty accesstoken credential
   	Then the task launch data fetched and verified with response error "Forbidden"
  
  @Get_powerbi_reports_invalid_accesstoken_pattern_api
  Scenario: This scenario is to get the data related to invalid accesstoken pattern
		When I send end point with BasePath that allows a user to get invalid access token pattern
   	Then the task launch data and verified with response error "Forbidden"
  
  @Get_powerbi_reports_api
  Scenario: This scenario is to get the data related to powetbi reports
		When I send end point with BasePath that allows a user to get the reports data
   	Then the task launch data fetched successfully and verified with name of reports

	@Get_individual_report_invalid_api
	Scenario: This scenario is to get the data related to invalid api of individual report
		When I send end point with BasePath that allows powerbi to get invalid individual api report data
		Then the launch data retrieved and verified with response error "Not Found"
	
	@Get_individual_report_empty_accesstoken_api
	Scenario: This scenario is to get the data related to empty access token api of individual report
		When I send end point with BasePath that allows powerbi to get empty accesstoken credential
		Then the launch data retrieved and verified with error response "Forbidden"
	
	@Get_individual_report_invalid_accesstoken_pattern_api
	Scenario: This scenario is to get the data related to invalid access token pattern of individual report
		When I send end point with BasePath that allows powerbi to get invalid accesstoken pattern
		Then the launched data retrieved and verified with response error "Forbidden"
	
	@Get_individual_report_api
	Scenario: This scenario is to get the data related to individual report
		When I send end point with BasePath that allows powerbi to get individual report data
		Then the report launch data retrieved successfully and verified with response body
		
	@Post_forgot_pwd_invalid_api
	Scenario: This scenario is to get the data related to invalid forgot password api
		When I send end point with BasePath that allows a user need to post invalid forgot password api data
		Then It launches successfully and verifies a error response as "Not Found"
	
	@Post_forgot_pwd_blank_email_data
	Scenario: This scenario is to get the data related to blank email of forgot password api
		When I send end point with BasePath that allows a user need to post blank email credential api
		Then It launches successfully and verified error response as "Bad Request"
	
	@Post_forgot_pwd_blank_reset_pwd_data
	Scenario: This scenario is to get the data related to blank reset password of forgot password api
		When I send end point with BasePath that allows a user need to post blank reset password credential api
		Then It launches successfully and verified response error as "Bad Request"
	
	@Post_forgot_pwd_invalid_email_key
	Scenario: This scenario is to get the data related to invalid email key of forgot password api
		When I send end point with BasePath that allows a user need to post with invalid email key
		Then It launches successfully and verified with response error "Bad Request"
	
	@Post_forgot_pwd_invalid_email_value
	Scenario: This scenario is to get the data related to invalid email value of forgot password api
		When I send end point with BasePath that allows a user need to post with invalid email value
		Then It launches successfully and verified with response as "User not found"
	
	@Post_forgot_pwd_invalid_reset_pwd_link_key
	Scenario: This scenario is to get the data related to invalid reset password link key of forgot password api
		When I send end point with BasePath that allows a user need to post with invalid reset password link key
		Then It launches successfully and verified with error response "Bad Request"
	
	@Post_forgot_pwd_blank_header
	Scenario: This scenario is to get the data related to blank header of forgot password api
		When I send end point with BasePath that allows a user to post with blank header of forgot password api
		Then It launched successfully and verified with error response "Unsupported Media Type"
	
	@Post_forgot_pwd_blank_body
	Scenario: This scenario is to get the data related to blank body of forgot password api
		When I send end point with BasePath that allows a user to post with blank body of forgot password api
		Then It launched successfully and verifies with error response "Bad Request"
	
	@Post_forgot_password_api
	Scenario: This scenario is to get the data related to forgot password api
		When I send end point with BasePath that allows a user need to post forgot password api data
		Then It launches data created successfully and verified the status code as '0'
