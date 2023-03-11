package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightpageObjects {

	@FindBy (xpath = "//li[@data-cy='oneWayTrip']")
	private WebElement oneWayTripCheckbox;
	
	@FindBy (xpath = "//li[@data-cy='roundTrip']")
	private WebElement roundTripCheckbox;
	
	@FindBy (xpath = "//li[@data-cy='multiCityTrip']")
	private WebElement multiCityTripCheckbox;
	
	public FlightpageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOneWayTripCheckboxPresent() {
	return oneWayTripCheckbox.isDisplayed();
}
	
	public boolean isRoundTripCheckboxPresent() {
		return roundTripCheckbox.isDisplayed();
	}
	
	public boolean isMultiCityTripCheckboxPresent() {
		return multiCityTripCheckbox.isDisplayed();
	}
	public String grabAtributeOfWayTrip(String attribute) {
		return oneWayTripCheckbox.getAttribute(attribute);
	}
}
