package config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import objRepository.CarRentalPageElements;
import objRepository.FlightPageElements;
import objRepository.HotelPageElements;



public class BaseDriver {

	
	static AppiumDriver appiumDriver;
	static DesiredCapabilities cap;
	static URL url;
	static BaseDriver baseDriver;
	
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException {
		setupEnvironment();
		
		navigateDashboardScreen(); 
		verifyFlightScreen(); 
		navigateDashboardScreen();
		verifyHotelScreen();
        navigateDashboardScreen(); 
        verifyCarRentalScreen();
	}
	
	public static void setupEnvironment() throws MalformedURLException, InterruptedException {
		  cap = new DesiredCapabilities();
		  cap.setCapability("deviceName", "realme C35");
		  cap.setCapability("udid", "0G02419R100032C1");
		  cap.setCapability("platformName", "Android");
		  cap.setCapability("platformVersion", "11");
		  cap.setCapability("appPackage", "net.skyscanner.android.main"); 
		  cap.setCapability("appActivity", "net.skyscanner.shell.ui.activity.SplashActivity");
		  url = new URL("http://0.0.0.0:4723/wd/hub");
	}
	
	static FlightPageElements flightPageElements;
	static HotelPageElements hotelPageElements;
	static CarRentalPageElements carRentalPageElements;
	
	public static void navigateDashboardScreen() {
		appiumDriver = new AppiumDriver(url, cap);
		
		flightPageElements = new FlightPageElements(appiumDriver);
		hotelPageElements = new HotelPageElements(appiumDriver);
		carRentalPageElements = new CarRentalPageElements(appiumDriver);
		
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
	
	public static void verifyFlightScreen() {
		flightPageElements.flightIcon.click();
		flightPageElements.fromField.click();
		WebElement airportFrom = flightPageElements.fromTextField;
		airportFrom.click();
		airportFrom.clear();
		airportFrom.sendKeys("lhr");
		flightPageElements.selectLondon.click();
		flightPageElements.FlyingToField.click();
		WebElement airportTo = flightPageElements.toTextField;
		airportTo.click();
		airportTo.clear();
		airportTo.sendKeys("che");
		flightPageElements.selectChennai.click();
		flightPageElements.searchIcon.click();
		String expectedPrice = flightPageElements.priceExpectedLabel.getText();
		flightPageElements.firstItem.click();
		String actualPrice = flightPageElements.priceActualLabel.getText();
		if(expectedPrice.equals(actualPrice)) {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are same in the checkout screen");
		}else {
			System.out.println("Expected: "+ expectedPrice +" and actual: "+actualPrice+" are not same in the checkout screen");
		}
	}
	public static void verifyHotelScreen() {
		hotelPageElements.hotelIcon.click();
		hotelPageElements.destinationField.click();
		WebElement hotelTextField = hotelPageElements.hotelTextField;
		hotelTextField.click();
		hotelPageElements.selectLondonItem.click();
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
	
	public static void verifyCarRentalScreen() throws InterruptedException {
		carRentalPageElements.carRentalIcon.click();
		Thread.sleep(5000);
		carRentalPageElements.fromLocation.click();
		carRentalPageElements.selectLondonLocation.click();
		carRentalPageElements.dropOffField.click();
		carRentalPageElements.dropOffField.click();
		WebElement airportTo = carRentalPageElements.dropOffTextField;
		airportTo.click();
		airportTo.sendKeys("dartford");
		carRentalPageElements.selectDartford.click();
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
