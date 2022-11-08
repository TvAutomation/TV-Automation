
Feature: Test Order Place Successfully from Webshop

@Regression
Scenario Outline: Verify that order place successfully with Invoice Payment Method
    Given User open browser and redirects to cart page
    When accept cookies
    And refresh cart page
    And close chat window
    And enter valid email
    And click on cotinue button
    And fills the form from sheetname "<SheetName>" and rownumber <RowNumber>
    And select Invoice Payment Method
    And select terms and condition check box
    Then Order place successfuly and user redirects to success page
    
    Examples:
          |SheetName|RowNumber|
          |Enter_Data|0|
    
@Regression
Scenario Outline: Verify that order place successfully with CC Payment Method
    Given Open browser and redirects to cart page
    When User accept cookies
    And User refresh cart page
    And User close chat window
    And User select additional concurrent users addon
    And User select MDS addon
    And User enters valid email
    And User click on cotinue button
    And User fills the form from given sheet "<SheetName>" and rownbr <RowNumber>
    And User select CC Payment Method
    And User select terms and condition check box
    And Click on Place Order button    
    Then Take Channel reference id on success page
    
    Examples:
          |SheetName|RowNumber|
          |Enter_Data|0|
    
    