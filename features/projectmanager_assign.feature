Feature: Assign project manager
    Description: A project manager gets assigned by a developer
    Actors: Developer
## Author: Victor Larsen-Saldeen
    Scenario: Assign project manager to a project
    Given that there is a developer with initials "vic7"
    And There is a project with id "22001"
    When the developer assigns the project manager with initials "ekki"
    Then the project manager "ekki" is assigned to the project

Scenario: Assign project manager to a project when no developer with such initials
    Given that there isn't a developer with initials "vigo"
    And There is a project with id "22001"
    When the developer assigns the project manager with initials "ekki"
    Then "vigo" is not assigned as project manager to the project

Scenario: Assign project manager that is already assigned
    Given that there is a developer with initials "ekki"
    And There is a project with id "22001"
    When the developer assigns the project manager with initials "ekki"
    Then "ekki" is still project manager

Scenario: Assign project manager to a non-exiting project
    Given that there is a developer with initials "ekki"
    And There is not a project with id "20000"
    When the developer tries to assigns the project manager with initials "ekki"
    Then no project manager assigned to the project

Scenario: Assign project manager whom not exist
    Given that there is a developer with initials "ekki"
    And There is a project with id "22001"
    When the developer assigns the project manager with initials "huba"
    Then "huba" is not assigned as project manager to the project