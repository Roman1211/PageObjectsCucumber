Feature: cart operations

  Scenario: Add item
    Given we open main page
    When we add item to cart
    Then number of items increases to 1
    And we add item to cart
    And number of items increases to 2
    And we add item to cart
    And number of items increases to 3

  Scenario: Delete items
    Given we open cart page
    When we delete all items one by one
    Then we close page




