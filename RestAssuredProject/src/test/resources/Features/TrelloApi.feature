Feature: Trello Api Feature

  Scenario: Create a Board
    Given The request specification is set up with the board name
    When POST request is sent to "/boards"
    Then The response status code should be 200

  Scenario: Update a Board
    Given The request specification is set up with the board ID and new name
    When PUT request is sent
    Then The response status code should be 200

  Scenario: Get a Board
    Given The request specification is set up with the board ID
    When GET request is sent
    Then The response status code should be 200

  Scenario: Delete a Board
    Given The request specification is set up with the board ID
    When DELETE request is sent
    Then The response status code should be 200
