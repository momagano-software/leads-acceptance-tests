@vip
Feature: User Registration
  As a potential customer
  I would like to register my profile
  So that I can find services

  Scenario: Potential customer has the correct details

#  Name  Surname Email Phone number

    Given Customer "Peter" has the following details:
      | Name  | Surname | Email           | Contact    |
      | Peter | Pater   | peter@gmail.com | 0111122334 |
    And he registers
    Then his profile should be created on the system

#  Scenario Outline: Mandatory fields should be captured
#    Given "John" has the following details:
#      | Name   | Trading Name   | Company Reg   | Email   | Contact   | Experience   | Working hours   | Location   | Portfolio   | Socials   | About   |
#      | <Name> | <Trading Name> | <Company Reg> | <Email> | <Contact> | <Experience> | <Working hours> | <Location> | <Portfolio> | <Socials> | <About> |
#    Then he should see error "<message(s)>"
#    And he shouldn't be able to submit
#    Examples:
#      | Name           | Trading Name | Company Reg    | Email             | Contact    | Experience | Working hours                                                                                    | Location | Portfolio | Socials                                      | About                     | message(s)                         |
#      |                | Dillinger Co | 1996/394028/01 | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Name is required                   |
#      | John Dillinger |              | 1996/394028/01 | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Trading name is required           |
#      | John Dillinger | Dillinger Co | 1996/394028/01 |                   | 0782356891 | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Email is required                  |
#      | John Dillinger | Dillinger Co | 1996/394028/01 | john@dillinger.co |            | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Contact number is required         |
#      | John Dillinger | Dillinger Co | 1996/394028/01 | john@dillinger.co | 0782356891 |            | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Experience is required             |
##      |John Dillinger|Dillinger Co  |1996/394028/01|john@dillinger.co|0782356891|10 years  |             |Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Working hours is required|
#      | John Dillinger | Dillinger Co | 1996/394028/01 | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 |          | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Location is required               |
#      | John Dillinger | Dillinger Co | 1996/394028/01 | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00,9:00 - 17:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00,08:00 - 16:00 | Cresta   |           | Twitter: @dillingerco,Instagram:@dillingerco | We are a plumbing company | Portfolio is required              |
#      | John Dillinger | Dillinger Co | 1996/394028/01 | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00, ,08:00 - 16:00, , , ,                                                             | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco |                           | A company description is required  |
#      | John Dillinger | Dillinger Co |                | john@dillinger.co | 0782356891 | 10 years   | 08:00 - 16:00, ,08:00 - 16:00, , , ,                                                             | Cresta   | Plumbing  | Twitter: @dillingerco,Instagram:@dillingerco |                           | A company registration is required |
