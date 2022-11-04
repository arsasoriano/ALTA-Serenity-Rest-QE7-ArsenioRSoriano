Feature: Reqres feature
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Respon body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Arsenio" and job "QA Engineer"
    And Validate create user json schema

  @Latihan
  Scenario Outline: : Put update user with valid json
    Given Put update user with valid json with id <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body should contain name "Arsenio Update" and job "QA Update"
    And Validate put update user json schema
  Examples:
    | id |
    | 1  |
    | 2  |

 @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send delete user request
    Then Status code should be 204 No Content
 Examples:
   | id |
   | 1  |
   | 2  |

