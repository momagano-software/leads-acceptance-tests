Feature: Profile Registration
  As a business owner
  I would like to register my business
  So that I can have a profile

  Scenario: Business has the details
    Given "John" has the following details:
      |Name          |Trading Name|Email            |Contact   |Experience|Working hours|Location|Portfolio|Socials                                     |About                    |
      |John Dillinger|Dilling Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|
    And he registers
    Then his profile should be created on the system