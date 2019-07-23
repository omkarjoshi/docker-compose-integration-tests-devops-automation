Feature: Hello World
  Hello World First BDD Test
Scenario: hello world response
  Given I have hello world service
  When I invoke Hello World Resource
  Then I should get JSON response:
      """
      {"name":"Omkar1","age":1,"address":"Dahisar"}
      """
