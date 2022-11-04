Feature: Reqres update user
  @tugas
  Scenario Outline: Put update user with valid json with invalid id
    Given Put update user with valid json with invalid id <id>
    When Send put update user requests
    Then Respon code should be 200 ok
    And Response body should contain name "Arsenio Update" and job "QA Update"
    And Validate put update user json schema
    Examples:
      | id |
      | 23 |
      | 50 |

  @tugas
  Scenario Outline: Put update user without job
    Given Put update user without job with valid id <id>
    When Send put update user requests
    Then Respon code should be 200 ok
    And Response body should contain name "Arsenio Update"
    And Validate update user json schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @tugas
  Scenario Outline: Put update user without name
    Given Put update user without name with valid id <id>
    When Send put update user requests
    Then Respon code should be 200 ok
    And Response body should contain job "QA Update"
    And Validate update user Json Schema
    Examples:
      | id |
      | 1  |
      | 2  |