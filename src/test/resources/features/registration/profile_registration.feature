Feature: Profile Registration
  As a business owner
  I would like to register my business
  So that I can have a profile

  Scenario: Business has the correct details
    Given "John" has the following details:
      |Name          |Trading Name|Email            |Contact   |Experience|Working hours|Location|Portfolio|Socials                                     |About                    |
      |John Dillinger|Dilling Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|
    And he registers
    Then his profile should be created on the system

  Scenario Outline: Mandatory fields should be captured
    Given "John" has the following details:
      |Name            |Trading Name  |Email              |Contact   |Experience  |Working hours  |Location  |Portfolio  |Socials                                       |About                      |
      |<Name>          |<Trading Name>|<Email>            |<Contact> |<Experience>|<Working hours>|<Location>|<Portfolio>|<Socials>                                     |<About>                    |
    And he registers
    Then he should see error "<message(s)>"
    And he shouldn't be able to submit
    Examples:
      |Name          |Trading Name|Email              |Contact   |Experience|Working hours|Location|Portfolio|Socials                                     |About                    |message(s)      |
      |              |Dillinger Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Name is required|
      |John Dillinger|              |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Trading name is required|
      |John Dillinger|Dillinger Co  |                 |0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Email is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|          |10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Contact number is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|0782356891|          |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Experience is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|0782356891|10 years  |             |Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Working hours is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|        |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Location is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |         |Twitter: @dillingerco,Instagram:@dillingerco|We are a plumbing company|Portfolio is required|
      |John Dillinger|Dillinger Co  |john@dillinger.co|0782356891|10 years  |08:00 - 16:00|Cresta  |Plumbing |Twitter: @dillingerco,Instagram:@dillingerco|                         |A company description is required|
