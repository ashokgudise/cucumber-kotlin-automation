Feature: Name Search in Google

#  @some-custome-tag
  Scenario Outline: Search My Name in Google
    Given open chrome browser and click on search
    When search for my name "<username>"
    Then I verify invalid login message
    Examples:
      | username               |
      | ashok gudise           |
