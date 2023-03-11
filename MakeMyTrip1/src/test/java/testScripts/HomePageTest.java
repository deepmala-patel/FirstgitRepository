package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import utils.Utility;

public class HomePageTest {
	WebDriver driver;
	HomePageObjects homepageobject;
	
	
	@Parameters({"myUrl","myBrowser"})
	@BeforeTest
	
	 void startApplication(String url, String browser) {
		
		 driver = Utility.launchBrowser(url,browser);
		 homepageobject=new HomePageObjects(driver);
		 
	}
		 
	
	
	   
	    @Test(priority=2)
	    void logoTest() {
	    	 
	    	boolean LogoFlag = homepageobject.isLogoPresent();
	    	Assert.assertTrue(LogoFlag, "Logo verified");
	}
	    
	    
	 
	    @Test  (priority=1)
	    void urlTest(String expectedUrl) {
	    	String actualUrl=driver.getCurrentUrl();
	    	Assert.assertEquals(actualUrl, expectedUrl,"Url test successful");
	    	
	    }
	    
	    @Parameters("myUrl")
	    @Test  (priority=3)
	    void verifyFlightsoptions()  {
	    	boolean flightflag= homepageobject.isFlightsOptionPresent();
	    	Assert.assertTrue(flightflag, "Flights options displayin");
	    	String actualUrl=driver.getCurrentUrl();
	    	Assert.assertEquals(actualUrl,"https://www.makemytrip.com/flights/","Flights page display");
	    }
	    @AfterTest
	    void quitBrowser() {
		driver.quit();
	    }
	    }


   
	