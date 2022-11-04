Feature: Reqres login feature
  @tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send post login user request
    Then Response Code should be 200 OK
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate post login user json schema

  @tugas
  Scenario: Post login user without email
    Given Post login user without email
    When Send post login user request
    Then Response Code should be 400 Bad Request
    And Response body should contain error messages "Missing email or username"
    And Validate login error messages json schema

  @tugas
  Scenario: Post login user without password
    Given Post login user without password
    When Send post login user request
    Then Response Code should be 400 Bad Request
    And Response body should contain error messages "Missing password"
    And Validate login error messages json schema