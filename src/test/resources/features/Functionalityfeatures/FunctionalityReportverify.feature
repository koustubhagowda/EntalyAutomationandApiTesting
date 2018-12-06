@Report_verify
Feature: I should able to verify the reports

@report_verify
  Scenario: trying to verify all reports loading or not
  	Given Iam on home page
    When I enter valid email "kkeshavaswamy@qwinix.io" and  valid password "Password1234"
    Then I click intelligent pricing solution in dashboard and reports in report page
    Then I should see displaying of reports

   