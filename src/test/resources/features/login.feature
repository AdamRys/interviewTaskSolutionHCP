#I am using Gherkin approach for better readability of whole structure of test automation
Feature: Login feature

  #First scenario - It's probably the most common - login
  Scenario: Successful login
    Given User has opened the login page
    When Input 'key:login' data to field with placeholder 'username'
    And Input 'key:password' data to field with placeholder 'Password'
    And Click login button
    Then User is logged in and see dashboard

    #As a bonus I've created also other cases for this feature,
    #because here was only need to reuse steps (besides assertion step),
    #which I've created during first step)
  Scenario: Unsuccessful login - wrong login
    Given User has opened the login page
    When Input 'key:password' data to field with placeholder 'username'
    And Input 'key:password' data to field with placeholder 'Password'
    And Click login button
    Then User should not be logged in

  Scenario: Unsuccessful login - wrong password
    Given User has opened the login page
    When Input 'key:login' data to field with placeholder 'username'
    And Input 'key:login' data to field with placeholder 'Password'
    And Click login button
    Then User should not be logged in