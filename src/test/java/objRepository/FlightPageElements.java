package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class FlightPageElements {
	public FlightPageElements(AppiumDriver appiumDriver){
		PageFactory.initElements(appiumDriver, this);
	}
	
	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/privacy_policy_accept_button']")
	public WebElement acceptButton;
	
	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/login_selection_skip_button']")
	public WebElement skipButton;

	@FindBy(id = "net.skyscanner.android.main:id/header_logo")
	public WebElement logoImage;

	// First TestCase
	@FindBy(id = "net.skyscanner.android.main:id/flights_icon")
	public WebElement flightIcon;

	@FindBy(xpath = "//*[@text='Departing From']")
	public WebElement fromField;

	@FindBy(className = "android.widget.EditText")
	public WebElement fromTextField;

	@FindBy(xpath = "//*[@text='London Heathrow']")
	public WebElement selectLondon;

	@FindBy(xpath = "//*[@text='Flying To']")
	public WebElement FlyingToField;

	@FindBy(xpath = "//*[@text='Country, city or airport']")
	public WebElement toTextField;

	@FindBy(xpath = "//*[@text='Chennai']")
	public WebElement selectChennai;

	@FindBy(xpath = "//*[@content-desc='SEARCH']")
	public WebElement searchIcon;

	@FindBy(xpath = "(//*[@resource-id='net.skyscanner.android.main:id/pricePerPerson'])[1]")
	public WebElement priceExpectedLabel;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/adHeader']")
	public WebElement firstItem;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/flightsConfigPrice']")
	public WebElement priceActualLabel;
}
