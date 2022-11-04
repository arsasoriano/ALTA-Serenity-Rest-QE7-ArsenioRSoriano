Feature: Reqres patch update user
  @tugas
  Scenario Outline: Patch update user with valid json
    Given Patch update user with valid json with valid id <id>
    When Send patch update user request
    Then Respon code should be 200 ok
    And Response body should contain name "Arsenio Update" and job "QA Update"
    And Validate patch update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |