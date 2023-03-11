package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Utility {
	static WebDriver driver;
	public static WebDriver launchBrowser(String url,String browser) {
		if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge,driver","C:\\Users\\Smart\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			 driver = new EdgeDriver();
		}
			 else if(browser.equalsIgnoreCase("chrome")) {
				 System.setProperty("webdriver.chrome.driver","C:\\Users\\Smart\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
			 }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			return driver;
		}
		
		
	}


