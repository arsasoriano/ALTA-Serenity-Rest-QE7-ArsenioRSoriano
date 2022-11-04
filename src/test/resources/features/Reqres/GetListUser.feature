Feature: Reqres get list user feature
  @tugas
  Scenario Outline: Get list user with invalid page
    Given Get list user with invalid parameter page "<page>"
    When Send get list user request
    Then Status Response code should be 404 Not Found
    Examples:
      | page |
      | abcd |
      | @@   |