package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightpageObjects;
import pageObjects.HomePageObjects;
import utils.Utility;

public class FlightsFunctionalityTest {
	WebDriver driver;
	HomePageObjects homepageobject;
	FlightpageObjects flightspageObjects;
	
	@Parameters({"myUrl","myBrowser"})
	@BeforeTest
	
	 void startApplication(String url, String browser) {
		
		 driver = Utility.launchBrowser(url,browser);
		 homepageobject=new HomePageObjects(driver);
		 flightspageObjects=new FlightpageObjects(driver);
	}
	@Test
	void verifyDifferentTripOptions()
	{
		boolean flightsflag=homepageobject.isFlightsOptionPresent();
		Assert.assertTrue(flightsflag,"Flights Option Displaying");
		homepageobject.clickOnFlights();
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://www.makemytrip.com/flights/","Flights page Open");
		
		boolean oneWayTripFlag = flightspageObjects.isOneWayTripCheckboxPresent();
		Assert.assertTrue(oneWayTripFlag, "One way trip checkbox displaying");
		
		boolean roundTripFlag = flightspageObjects.isRoundTripCheckboxPresent();
		Assert.assertTrue(roundTripFlag, "round trip checkbox displaying");
		
		boolean multicityTripFlag = flightspageObjects.isMultiCityTripCheckboxPresent();
		Assert.assertTrue(multicityTripFlag, " milti city trip checkbox displaying");
		}
	
     void verifyDefualtTripSelection() {
    	 String actualAttribute =flightspageObjects.grabAtributeOfWayTrip("class");
    	 Assert.assertEquals(actualAttribute, "selected","By Dafault OneWayTrip Option is selected");
     }
     @AfterTest
     void quitBrowser() {
 		driver.quit();
 	    }
	

}
