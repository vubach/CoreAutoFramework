@ExportWeatherData
Feature: Export Weather Data 
  As a user
  I want to extract Singapore weather data based on selected timeframe

@SWD_01
Scenario Outline: SWD_01 - Export weather data into test report  
	Given user launches application under test 
		And "FORECAST_PAGE" shows up 
	#When user clicks on menu following orders "Weather > Yesterday/Past Weather"
	When user clicks on "FORECAST_PAGE_PAST_WEATHER_LINK"	
	Then "PAST_WEATHER_PAGE" shows up
		And "PAST_WEATHER_PAGE_WEATHER_LINKS_AREA" is present
	When user select "PAST_WEATHER_PAGE_SELECT_MONTH_DROPDOWN" as "<timeframe>"  
	Then user export weather data into test report  
	
	Examples:
		| timeframe    |
		| Past 2 Weeks | 
	
	
      