Feature: Service Now API CRUD Operations

  Background:
    Given BasicAuthenticaion

  Scenario: Create incidents
    When Create incident with body '{"short_description" :"jeep", "description" : "Jeep Front wheel change"}'
    Then validate the status Code 201

  Scenario: Get incidents
    When Get incident
    Then validate the status Code 200


    Scenario Outline: Update Incident with JSON File
      When Put incident with '<fileName>'
      Then validate the status Code
      Examples:
        |FileName|
        |FileJSONData.json|


