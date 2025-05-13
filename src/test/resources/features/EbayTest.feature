Feature: Ebay test

  Scenario: Order two Monopolies on Ebay
    Given I navigate to "https://ebay.com/" page
      And "www.ebay.com" page is open
      And I select "Toys & Hobbies" from "All Categories" dropdown
      And I provide text "Monopoly: Elf Edition Board Game" in searchbox
      And I click on "Search" button
      And I verify that the first found item has title "Monopoly"
      And I verify that the item could be shipped to "Bulgaria"
      And I verify and store the price of the first item
    When I click on the first item
      And I verify that the name contains "Monopoly"
      And I verify that the price is the same as on the first page
      And I click on See details link
      And I check that the item can be shipped to "Bulgaria"
      And I provide "2" in quantity input
      And I click on "Add to cart" element
      And "https://cart.payments.ebay.com/" page is open
      And I verify that quantity in quantity drop down list is "2"
    Then I verify that the price is displayed for two items
