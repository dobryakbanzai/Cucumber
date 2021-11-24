Feature: I want to test login

  Scenario: I want to login with correct credentials
    Given I go to main page
    When I login as "SalikhovMZM" with password "vfvfgfgf37447877mz"
    Then I have been successfully logged

  Scenario: I want to check my personal profile information
    Given I go to main page
    When I login as "SalikhovMZM" with password "vfvfgfgf37447877mz"
    And I check my services
    And I check my email
    Then I was convinced of the existence of such tabs
  Scenario: I want to upload a photo to my personal account,
  delete it and download one of the applications.
    Given I go to main page
    When I login as "SalikhovMZM" with password "vfvfgfgf37447877mz"
    And I go to my Disk
    And I'm uploading a photo
    Then I am certified that the photo has been uploaded ,the file has been downloaded
  Scenario: I want to download a file from my personal account.
    Given I go to main page
    When I login as "SalikhovMZM" with password "vfvfgfgf37447877mz"
    And I go to my Disk
    And I'm downloading file
    And I go to the applications section and download one of them
    Then I am certified that the photo has been uploaded ,the file has been downloaded