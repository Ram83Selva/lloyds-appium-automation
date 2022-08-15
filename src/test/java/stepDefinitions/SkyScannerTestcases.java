package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.BaseDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objRepository.CarRentalPageElements;
import objRepository.FlightPageElements;
import objRepository.HotelPageElements;

public class SkyScannerTestcases {
	
	static AppiumDriver appiumDriver;
	static DesiredCapabilities cap;
	static URL url;
	static BaseDriver baseDriver;
	@Before
	public void setUpEnvironment() {
		
		  cap = new DesiredCapabilities();
		  cap.setCapability("deviceName", "realme C35");
		  cap.setCapability("udid", "0G02419R100032C1");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("platformVersion", "11");
		  cap.setCapability("appPackage", "net.skyscanner.android.main"); 
		  cap.setCapability("appActivity", "net.skyscanner.shell.ui.activity.SplashActivity");
		  System.out.println("Hello");
	}
	/*
	 * @Given("set the android os environment") public void
	 * set_the_android_os_environment() { System.out.println("Hello"); cap = new
	 * DesiredCapabilities(); cap.setCapability("deviceName", "realme C35");
	 * cap.setCapability("udid", "0G02419R100032C1");
	 * cap.setCapability("platformName", "Android");
	 * cap.setCapability("platformVersion", "11");
	 * 
	 * }
	 * 
	 * @When("set the application package and activity") public void
	 * set_the_application_package_and_activity() { cap.setCapability("appPackage",
	 * "net.skyscanner.android.main"); cap.setCapability("appActivity",
	 * "net.skyscanner.shell.ui.activity.SplashActivity");
	 * 
	 * }
	 */
	
	static FlightPageElements flightPageElements;
	static HotelPageElements hotelPageElements;
	static CarRentalPageElements carRentalPageElements;
	
	@Given("request a url to the Appium Driver")
	public void request_a_url_to_the_appium_driver() throws MalformedURLException {
		url = new URL("http://0.0.0.0:4723/wd/hub");
		appiumDriver = new AppiumDriver(url, cap);
		flightPageElements = new FlightPageElements(appiumDriver);
		hotelPageElements = new HotelPageElements(appiumDriver);
		carRentalPageElements = new CarRentalPageElements(appiumDriver);
		
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("allow the cookies by clicking on the ok button")
	public void allow_the_cookies_by_clicking_on_the_ok_button() {
		flightPageElements.acceptButton.click();
		flightPageElements.skipButton.click();
		try {
			if(flightPageElements.logoImage.isDisplayed()) {
				System.out.println("Navigated to Dashboard screen");
			}
		}catch(NoSuchElementException e) {
			System.out.println("Test Failed");
		}
	}
	
	@Given("navigate to Flights section")
	public void navigate_to_flights_section() {
		flightPageElements.flightIcon.click();
	}

	@When("enter the from flight")
	public void enter_the_from_flight() {
		flightPageElements.fromField.click();
		WebElement airportFrom = flightPageElements.fromTextField;
		airportFrom.click();
		airportFrom.clear();
		airportFrom.sendKeys("lhr");
		flightPageElements.selectLondon.click();
	}

	@Then("enter the to flight")
	public void enter_the_to_flight() {
		flightPageElements.FlyingToField.click();
		WebElement airportTo = flightPageElements.toTextField;
		airportTo.click();
		airportTo.clear();
		airportTo.sendKeys("che");
		flightPageElements.selectChennai.click();
	}

	@And("search flight and verify the price in flight screen and checkout screen")
	public void search_flight_and_verify_the_price_in_flight_screen_and_checkout_screen() {
		flightPageElements.searchIcon.click();
		String expectedPrice = flightPageElements.priceExpectedLabel.getText();
		flightPageElements.priceExpectedLabel.click();
		String actualPrice = flightPageElements.priceActualLabel.getText();
		if(expectedPrice.equals(actualPrice)) {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are same in the checkout screen");
		}else {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are not same in the checkout screen");
		}
	}

	@Given("navigate to Hotels section")
	public void navigate_to_hotels_section() {
		hotelPageElements.hotelIcon.click();
	}

	@When("enter the from Hotels")
	public void enter_the_from_hotels() {
		hotelPageElements.destinationField.click();
		WebElement hotelTextField = hotelPageElements.hotelTextField;
		hotelTextField.click();
		hotelPageElements.selectLondonItem.click();
	}

	@Then("search Hotels and verify the price in Hotels screen and checkout screen")
	public void search_hotels_and_verify_the_price_in_hotels_screen_and_checkout_screen() {
		String expectedHotelPrice = hotelPageElements.expectedLabel.getText();
		hotelPageElements.expectedLabel.click();
		hotelPageElements.gotItButton.click();
		String actualHotelPrice;
		try {
			hotelPageElements.actualPriceLabel1.isDisplayed();
			 actualHotelPrice = hotelPageElements.actualPriceLabel1.getText();
		}catch(NoSuchElementException e) {
			 actualHotelPrice = hotelPageElements.actualPriceLabel2.getText();
		}
		if(expectedHotelPrice.contains(actualHotelPrice.replace(".00", ""))) {
			System.out.println("Expected: "+ expectedHotelPrice +" and actual: "+actualHotelPrice+" are same in the checkout screen");
		}else {
			System.out.println("Expected: "+ expectedHotelPrice +" and actual: "+actualHotelPrice+" are not same in the checkout screen");
		}
	}

	@Given("navigate to Car Rental section")
	public void navigate_to_car_rental_section() throws InterruptedException {
		carRentalPageElements.carRentalIcon.click();
		Thread.sleep(5000);
	}

	@When("enter the from Car Rental")
	public void enter_the_from_car_rental() {
		carRentalPageElements.fromLocation.click();
		carRentalPageElements.selectLondonLocation.click();
	}

	@Then("enter the to Car Rental")
	public void enter_the_to_car_rental() {
		carRentalPageElements.dropOffField.click();
		carRentalPageElements.dropOffField.click();
		WebElement airportTo = carRentalPageElements.dropOffTextField;
		airportTo.click();
		airportTo.sendKeys("dartford");
		carRentalPageElements.selectDartford.click();
	}

	@And("search Car Rental and verify the price in Car Rental screen and checkout screen")
	public void search_car_rental_and_verify_the_price_in_car_rental_screen_and_checkout_screen() {
		carRentalPageElements.carSearchIcon.click();
		String expectedPrice = carRentalPageElements.expectedCarPrice.getText();
		carRentalPageElements.expectedCarPrice.click();
		String actualPrice = carRentalPageElements.actualCarPrice.getText();
		if(expectedPrice.equals(actualPrice)) {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are same in the checkout screen");
		}else {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are not same in the checkout screen");
		}
	}
}
