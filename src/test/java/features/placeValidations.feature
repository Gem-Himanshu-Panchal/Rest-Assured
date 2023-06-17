Feature: Validating Place APIs

  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>", "<language>" and "<address>"
    When User calls "addPlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Examples:
      | name   | language | address         |
      | AHouse | English  | 123,xyz,xyz,xyz |
      | BHouse | Hindi    | 098,abc,abc,abc |