package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	
	
	
	@FindBy (xpath ="//img[@alt='Make My Trip']")
	private WebElement logo;
	
	
		@FindBy (xpath ="//span[text()='Flights']")
		private WebElement flights;

		public HomePageObjects(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		


       public  boolean isLogoPresent() {
	   return logo.isDisplayed();
}
     
       
       public void clickOnLogo() {
        logo.click();
}

      public boolean isFlightsOptionPresent() {
	   return flights.isDisplayed();
}

      public void clickOnFlights() {
	 flights.click();
}
}