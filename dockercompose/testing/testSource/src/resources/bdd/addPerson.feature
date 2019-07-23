Feature: Add Person

Scenario: Add person in database
  Given I have add person resource available
  When I invoke add person resource
  Then I should get person record in database