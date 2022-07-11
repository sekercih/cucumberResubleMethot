@requestatrial
Feature: User should not login with invalid e-mail and password
  Scenario: User tries to login with invalid email and password

    Given User goes to ravenpack url mainpage
    And User validates that he has entered the home page
    And User clicks to the request a Trial button
    And User enters name to full name box
    And User enters email to email box
    And User selects how he heard about Raven Pack
    And User cliks terms and conditions checkbox
    Then User cliks keep me updated checkbox
 #   Then User cliks submit button
  #  Then User verifies succesful submit message