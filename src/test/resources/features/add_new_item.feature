@LoginRequired
Feature: Adding new item

  #Second scenario - it seems that adding new item is crucial for this app
  Scenario: Add successfully new item with all data filled
    Given User has opened the main page
    When Click navigation button
    And Click add button
    And Input 'new Title' data to field with placeholder 'title'
    And Input 'new Description' data to field with placeholder 'description'
    And Input '5' data to field with placeholder 'estimate'
    And Select 'High' option from 'Priority' dropdown list
    And Input '/activity6.jpeg' data to field with placeholder 'image URL'
    And Click submit button
    Then New item is added with 'new Title' title
    And New item is added with 'new Description' description
    And New item is added with 'Hours: 5' progressbar
    And New item is added with 'High' priority label
    And New item with title 'new Title' is added with '/activity6.jpeg' URL





