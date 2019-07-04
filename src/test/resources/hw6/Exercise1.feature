@run1
Feature: Exercise1

  Scenario: EPAM's JDI website test
    Given I am on the JDI Index Page
    Then Browser title equals 'MAIN_TITLE'
    When I login as 'LOGIN'/'PASSWORD'
    Then User name should be 'USER_NAME'
    And Home Page should contain '4' pictures
    And Home Page should contain '4' texts under pictures
    And Home Page should contain '2' texts above headline and description
    When I click on Service subcategory in the header
    Then Service subcategory in the header should contain options
      | SUPPORT |
      | DATES |
      | SEARCH |
      | COMPLEX TABLE |
      | SIMPLE TABLE |
      | USER TABLE |
      | TABLE WITH PAGES |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE |
    When I click on Service subcategory in the left section
    Then Service subcategory in the left section should contain options
      | Support |
      | Dates |
      | Complex Table |
      | Simple Table |
      | Search |
      | User Table |
      | Table with pages |
      | Different elements |
      | Performance |
    When I open Different Elements Page through Service header menu
    Then Different elements page should contain '4' checkboxes
    And Different elements page should contain '4' radios
    And Different elements page should contain '1' dropdown
    And Different elements page should contain '2' buttons
    And Different elements page should contain Right Section
    And Different elements page should contain Left Section
    When I select checkboxes
      | WATER |
      | WIND  |
    Then Log should contain checkboxes names and its status corresponding to selected
      | WATER_TRUE |
      | WIND_TRUE  |
    When I select radiobutton 'SELEN'
    Then Log should contain radiobutton name and its status corresponding to selected 'METAL_SELEN'
    When I select dropdown 'YELLOW'
    Then Log should contain dropdown name and its status corresponding to selected 'COLORS_YELLOW'
    When I unselect checkboxes
      | WATER |
      | WIND  |
    Then Log should contain checkboxes names and its status corresponding to unselected
      | WATER_FALSE |
      | WIND_FALSE  |