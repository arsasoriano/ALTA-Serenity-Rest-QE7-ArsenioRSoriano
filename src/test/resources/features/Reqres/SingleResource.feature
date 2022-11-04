Feature: Reqres get single resource
  @tugas
  Scenario Outline: Get single resource with valid id
    Given Get single resource with parameter id <id>
    When Send get resource user request
    Then Status Response code should be 200 OK
    And Response Body code should contain id <id>
    And Validate get single list resource json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @tugas
  Scenario Outline: Get single resource with invalid id
    Given Get single resource with parameter id <id>
    When Send get resource user request
    Then Status Response code should be 404 Not Found
    Examples:
      | id |
      | 23 |
      | 50 |