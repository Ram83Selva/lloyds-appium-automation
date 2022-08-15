package config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SkyScannerPage {

	SkyScannerPage(AppiumDriver appiumDriver){
		PageFactory.initElements(appiumDriver, this);
	}
	
	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/privacy_policy_accept_button']")
	WebElement acceptButton;
	
	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/login_selection_skip_button']")
	WebElement skipButton;

	@FindBy(id = "net.skyscanner.android.main:id/header_logo")
	WebElement logoImage;

	// First TestCase
	@FindBy(id = "net.skyscanner.android.main:id/flights_icon")
	WebElement flightIcon;

	@FindBy(xpath = "//*[@text='Departing From']")
	WebElement fromField;

	@FindBy(className = "android.widget.EditText")
	WebElement fromTextField;

	@FindBy(xpath = "//*[@text='London Heathrow']")
	WebElement selectLondon;

	@FindBy(xpath = "//*[@text='Flying To']")
	WebElement FlyingToField;

	@FindBy(xpath = "//*[@text='Country, city or airport']")
	WebElement toTextField;

	@FindBy(xpath = "//*[@text='Chennai']")
	WebElement selectChennai;

	@FindBy(xpath = "//*[@content-desc='SEARCH']")
	WebElement searchIcon;

	@FindBy(xpath = "(//*[@resource-id='net.skyscanner.android.main:id/pricePerPerson'])[1]")
	WebElement priceExpectedLabel;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/adHeader']")
	WebElement firstItem;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/flightsConfigPrice']")
	WebElement priceActualLabel;

	
	// Second TestCase
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Hotels\"]")
	WebElement hotelIcon;

	@FindBy(xpath = "//*[@text='Destination or hotel name']")
	WebElement destinationField;

	@FindBy(className = "android.widget.EditText")
	WebElement hotelTextField;

	@FindBy(xpath = "//*[@text='London']")
	WebElement selectLondonItem;

	@FindBy(xpath = "(//*[contains(@text,'a night')])[1]")
	WebElement expectedLabel;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Got it\"]/android.widget.TextView")
	WebElement gotItButton;

	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'£')])[2]")
	WebElement actualPriceLabel1;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'£')]")
	WebElement actualPriceLabel2;
	
	// Third TestCase
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Car Rental']")
	WebElement carRentalIcon;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/singleLocationText']")
	WebElement fromLocation;

	@FindBy(xpath = "//*[@text='London']")
	WebElement selectLondonLocation;

	@FindBy(xpath = "//*[contains(@text,'Drop-off')]")
	WebElement dropOffField;

	@FindBy(xpath = "//*[contains(@text,'City, airport')]")
	WebElement dropOffTextField;

	@FindBy(xpath = "(//*[contains(@text,'Dartford')])[1]")
	WebElement selectDartford;

	@FindBy(xpath = "//*[@content-desc='Search']")
	WebElement carSearchIcon;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/txtPrice']")
	WebElement expectedCarPrice;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/carhireQuotesPrice']")
	WebElement actualCarPrice;
}
