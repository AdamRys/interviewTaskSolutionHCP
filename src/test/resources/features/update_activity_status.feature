@LoginRequired @AddTestItem
Feature: Update Activity Status

    #Third scenario - together with first and second scenario it makes good flow of "most important" features of this app - that's why I picked it to automate
  Scenario: Update Activity Status - Activity Done
      Given User has opened the main page
      When Click done button of 'test title' item
      And Navigate to activity page
      Then Verify if task 'test title' is on table with 'Moved to done' status