package objRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class HotelPageElements {
	
	public HotelPageElements(AppiumDriver appiumDriver){
		PageFactory.initElements(appiumDriver, this);
	}
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Hotels\"]")
	public WebElement hotelIcon;

	@FindBy(xpath = "//*[@text='Destination or hotel name']")
	public WebElement destinationField;

	@FindBy(className = "android.widget.EditText")
	public WebElement hotelTextField;

	@FindBy(xpath = "//*[@text='London']")
	public WebElement selectLondonItem;

	@FindBy(xpath = "(//*[contains(@text,'a night')])[1]")
	public WebElement expectedLabel;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Got it\"]/android.widget.TextView")
	public WebElement gotItButton;

	@FindBy(xpath = "(//android.widget.TextView[contains(@text,'£')])[2]")
	public WebElement actualPriceLabel1;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'£')]")
	public WebElement actualPriceLabel2;
}
