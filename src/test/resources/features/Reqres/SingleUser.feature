Feature: Reqres get single user
  @tugas
  Scenario Outline: Get single user with valid id
    Given Get single user with parameter id <id>
    When Send get single user request
    Then Status response code should be 200 OK
    And Response body code should contain id <id>
    And Validate get single list user json schema
  Examples:
    | id |
    | 1  |
    | 2  |

  @tugas
  Scenario Outline: Get single user with invalid id
    Given Get single user with parameter id <id>
    When Send get single user request
    Then Status response code should be 404 Not Found
  Examples:
    | id |
    | 23 |
    | 50 |
