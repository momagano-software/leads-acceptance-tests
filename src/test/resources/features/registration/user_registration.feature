Feature: User Registration
  As a potential customer
  I would like to register my profile
  So that I can find services

  Scenario: Potential customer has the correct details

    Given Customer "Peter" has the following details:
      | Name  | Surname | Email           | Contact    |
      | Peter | Pater   | peter@gmail.com | 0111122334 |
    And he submits
    Then his customer profile should be created on the system

  @vip
  Scenario Outline: Mandatory fields should be captured
    Given Customer "Peter" has the following details:
      | Name   | Surname   | Email   | Contact   |
      | <Name> | <Surname> | <Email> | <Contact> |

    Then Peter should see error "<message(s)>"
    And Peter shouldn't be able to submit
    Examples:
      | Name  | Surname | Email           | Contact    | message(s)                 |
      |       | Pater   | peter@gmail.com | 0111122334 | Name is required           |
      | Peter |         | peter@gmail.com | 0111122334 | Surname is required        |
      | Peter | Pater   |                 | 0111122334 | Email is required          |
      | Peter | Pater   | peter@gmail.com |            | Contact number is required |
