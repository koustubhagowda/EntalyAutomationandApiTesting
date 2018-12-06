@Data_cleansing
Feature: I should able to search all the data

Background: user able to search all data
Given Iam on home page

 @Search_data
 Scenario: trying to search the all data
	   When I enter  email "kkeshavaswamy@qwinix.io" and   password "Password1234"
	   Then I click data cleansing in dashboard and click on go button
	   Then I should see the "No names selected."
	   Then I should see the no of records "222 matching records found."
	   Then I should see "Record Saved Successfully."
	   
 @search_lesstham_3chars
 Scenario: trying serach the result for less than 3 charcters
 		When I enter "kkeshavaswamy@qwinix.io" and "Password1234"
 		And I enter less than three chars in serach filed 
 		Then I should get error as "Please enter a minimum of 3 chars"
# 		
 @search_invaldata
 Scenario: trying serach for invalid data
 		When I enter email "kkeshavaswamy@qwinix.io" and "Password1234"
 		And I enter invalid data in search field 
 		Then I should get "No matching records found."
	  	
 @empty_select_all
 Scenario: trying to edit the data in data cleansing
	 	When I enter valid "kkeshavaswamy@qwinix.io" and password "Password1234"
		When I click on select all and apply selection button
		Then I should see the error "No names selected."
    
 @select_all_data
 Scenario: trying to select all data in data cleansing
		When I enter valid email "kkeshavaswamy@qwinix.io" and valid password "Password1234"
		And I click select all and click on apply selection
		Then I should see the message "Records Saved Successfully."
		
 @select_deselect_checkbox
 Scenario: trying select and deslelect the checkbox
 		When I select all checkbox and enter text again deselect the checkbox click on applyselection
 		Then I should see the text change in data cleansing page