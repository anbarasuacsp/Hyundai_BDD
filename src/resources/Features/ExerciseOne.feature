@GlobalTag
Feature: First Exercise
  @ScenarioTag
  Scenario Outline: : To Verify the First Scenario
    Given Launch The Url
    And Choose The First Option From Model Drop Down "<CarModel>"
    And Choose The First Option From Fuel Type Drop Down "<Fuel>"
    And Choose The First Option From Variant Drop Down
    And Choose The First Option From Exterior Drop Down
    Then Choose The States Cities Dealers Respectively and Get the Product Details for each Selection
    Examples:
      | CarModel  | Fuel   |  |
      | New Verna | Petrol |  |