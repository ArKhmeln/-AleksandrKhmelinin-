@run2
Feature: Exercise2

  Scenario: User Table Page test
    Given I am on the JDI Index Page
    And I login as 'LOGIN'/'PASSWORD'
    When I click on Service subcategory in the header
    And I click on User Table button in Service dropdown
    Then Browser title equals 'USER_TABLE_TITLE'
    And '6' NumberType Dropdowns are displayed on Users Table on User Table Page
    And '6' User names are displayed on Users Table on User Table Page
    And '6' Description images are displayed on Users Table on User Table Page
    And '6' Description texts under images are displayed on Users Table on User Table Page
    And User table contains following values:
      | Number         | User                |  Description                       |
      | 1              | Roman               |  Wolverine                         |
      | 2              | Sergey Ivan         |  Spider Man                        |
      | 3              | Vladzimir           |  Punisher                          |
      | 4              | Helen Bennett       |  Captain America some description  |
      | 5              | Yoshi Tannamuri     |  Cyclope some description          |
      | 6              | Giovanni Rovelli    |  Hulk some description             |
    When I select vip checkbox for 'SERGEY_IVAN'
    Then '1' log row has 'VIP_TRUE' text in log section
    When I click on dropdown in column Type for user 'ROMAN'
    Then Droplist for user 'ROMAN' contains values
      | Admin           |
      | User            |
      | Manager         |
