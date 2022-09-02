#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: login page
  This verifies user credentials in nopCommerce login page

 
  Scenario: Verify user can login with valid email address and password
    Given user is in nopCormmece login page
    When user enters valid email address
    And user enters valid password
    And user clicks login button
    Then user should be in admin page
    And user clicks logout button
    
   

 
  Scenario Outline: Verify user cannot login with invalid email address and valid password
    Given user is in nopCormmece login page
    When user enters invalid email address
    And user enters valid password
    And user clicks login button
    Then  MESSAGE No customer account found SHOULD DISPLAY
		
		
		
		Scenario Outline: Verify user cannot login with valid email address and invalid password
    Given user is in nopCormmece login page
    When user enters valid email address
    And user enters invalid password
    And user clicks login button
    Then MESSAGE The credentials provided are incorrect SHOULD DISPLAY
		

