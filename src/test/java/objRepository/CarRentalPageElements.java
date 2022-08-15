package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CarRentalPageElements {
	
	public CarRentalPageElements(AppiumDriver appiumDriver){
		PageFactory.initElements(appiumDriver, this);
	}
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Car Rental']")
	public WebElement carRentalIcon;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/singleLocationText']")
	public WebElement fromLocation;

	@FindBy(xpath = "//*[@text='London']")
	public WebElement selectLondonLocation;

	@FindBy(xpath = "//*[contains(@text,'Drop-off')]")
	public WebElement dropOffField;

	@FindBy(xpath = "//*[contains(@text,'City, airport')]")
	public WebElement dropOffTextField;

	@FindBy(xpath = "(//*[contains(@text,'Dartford')])[1]")
	public WebElement selectDartford;

	@FindBy(xpath = "//*[@content-desc='Search']")
	public WebElement carSearchIcon;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/txtPrice']")
	public WebElement expectedCarPrice;

	@FindBy(xpath = "//*[@resource-id='net.skyscanner.android.main:id/carhireQuotesPrice']")
	public WebElement actualCarPrice;
}
