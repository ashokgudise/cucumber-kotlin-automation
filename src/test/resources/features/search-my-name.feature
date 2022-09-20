Feature: Name Search in Google

  Scenario Outline: Search My Name in Google
    Given open chrome browser and click on search
    When search for my name "<username>"
    Then verify the name appears from my LinkedIn Profile
    Examples:
      | username               |
      | ashok gudise           |
