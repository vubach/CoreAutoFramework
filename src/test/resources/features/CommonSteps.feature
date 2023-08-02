@common 
Feature: Common Steps 

@common-01 
Scenario Outline: User actions to interact with web element
	Given user launches application under test 
	And "LOGIN_PAGE" shows up	
	And user types "<username>" into "LOGIN_PAGE_USERNAME_INPUT"	
	When user clicks on "LOGIN_PAGE_LOGIN_BUTTON"
	When user submits form "LOGIN_PAGE_LOGIN_FORM"
	And user waits for 10 seconds  	
	Then "HOME_PAGE" shows up in 30 seconds
	And "HOME_PAGE_DASHBOARD_LABEL" is present
	Then "HOME_PAGE_DASHBOARD_LABEL" is present in 30 seconds 
	And "LOGIN_PAGE_LOGIN_BUTTON" is not present
	And "LOGIN_PAGE_LOGIN_BUTTON" is not present in 30 seconds	
	And "HOME_PAGE_DASHBOARD_LABEL" shows text "Dashboard"
	And "HOME_PAGE_DASHBOARD_LABEL" contains text "Dashb"	
	And "HOME_PAGE_SUBSCRIBE_BUTTON" has attribute "class" with value "button" 
	And "HOME_PAGE_SUBSCRIBE_BUTTON" has attribute "id" contain value "_link"
	And user refreshes current page
	And user navigates to "<url>"
	And user navigates back  
	And user navigates forward 
	And user switches to "ANY_IFRAME" 
	And user switches to default
	And user scrolls down 200 pixel
	And user scrolls down 200 pixel 3 times
	And user scrolls to "PIM_EMPLOYEE_LIST_PAGE_FOOTER_LINK"
	And user presses ENTER key
	And user clicks on "LOGIN_PAGE_LOGIN_BUTTON" by JS
	And user clicks on menu following order "PIM > Employee List" 
	
	Examples:
    | username | password | url                        |
    |    Admin | admin123 | https://www.google.com.vn/ |
  

      