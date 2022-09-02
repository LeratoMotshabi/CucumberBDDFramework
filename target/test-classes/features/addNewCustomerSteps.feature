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

Feature: New customer
  I want to verify if user can add new customer and Edit customer details
  

  

Scenario: Verify that new customer can be added successfully
  Given user can login to nopCommerce dashboard
    And user is in customers page 
    When user clicks add new button
    And user enters "<email>" in email
    And user enters guest or registered in customer role
    And user clicks save button
    Then MESSAGE The new customer has been added successfully. MUST DISPLAY
    And customer unique email address should reflect in customers list
    And user clicks logout button
   

  
Scenario: Verify that customer details can be edited successfully
  Given user can login to nopCommerce dashboard
    And user is in customers page 
    When user clicks Edit button 
    And user enters first name
    And user clicks save button
    Then MESSAGE The customer has been updated successfully. MUST DISPLAY
    And customer updated name should reflect in customers list
    And user clicks logout button


    