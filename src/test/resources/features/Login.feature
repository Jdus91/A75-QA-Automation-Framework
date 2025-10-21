Feature: Login Feature

  #This is a comment

  Scenario:
    Given I open browser
    And I open Login Page
    When I enter email "jennifer.de.jesus@testpro.io"
    And I enter password "FCVlLOni"
    And I submit
    Then I am logged in