Feature: RestAssured TestNG Annotation, use of Data Provider to pass parameters

  Scenario: use of data provider to parameterize the values
    Given API for foreign exchange
    When posted with future date value
    Then validate positive response code
