Feature: Reqres register user
  @tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send post register user request
    Then Response code should be 200 OK
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Validate post register user json schema

  @tugas
  Scenario: Post register user without password
    Given Post register user without password json
    When Send post register user request
    Then Response code should be 400 Bad Request
    And Response body should contain error "Missing password"
    And Validate register error messages json schema

  @tugas
  Scenario: Post register user without email
    Given Post register user without email json
    When Send post register user request
    Then Response code should be 400 Bad Request
    And Response body should contain error "Missing email or username"
    And Validate register error messages json schema