Feature: Test and Verify the Dashboard and three main components such as Flight, Hotels and Car Rentals
	In order to test the Sky Scanner application
	Open the Sky Scanner application in Android OS
	I want to open the Dashboard screen of Sky Scanner application

Background: Set up the Android mobile and open the SkyScanner application
	Given request a url to the Appium Driver
	Then allow the cookies by clicking on the ok button 
	
Scenario: Verify the Flights component
    Given navigate to Flights section
    When enter the from flight
    Then enter the to flight	
	And search flight and verify the price in flight screen and checkout screen
		
Scenario: Verify the Hotels component
    Given navigate to Hotels section
    When enter the from Hotels
    Then search Hotels and verify the price in Hotels screen and checkout screen	
		
Scenario: Verify the Car Rental component
    Given navigate to Car Rental section
    When enter the from Car Rental
    Then enter the to Car Rental	
	And search Car Rental and verify the price in Car Rental screen and checkout screen