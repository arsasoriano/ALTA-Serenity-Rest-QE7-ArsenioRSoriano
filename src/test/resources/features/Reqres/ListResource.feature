Feature: Reqres get list resource
  @tugas
  Scenario Outline: Get list resource with valid parameter page
    Given Get list resource with parameter page <page>
    When Send get list resource request
    Then Response status code should be 200 OK
    And Response body code should be <page>
    And Validate get list resource json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @tugas
  Scenario Outline: Get list resource with invalid parameter page
    Given Get list resource with parameter page <page>
    When Send get list resource request
    Then Response status code should be 200 OK
    And Response body code should be <page>
    And Validate get list resource json schema
    Examples:
      | page |
      | 23   |
      | 50   |