package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	static WebDriver driver;		//declaring a variable of type webdriver
	static Properties properties;		//declaring a variable of type properties
	static Logger logger;		//declaring a variable of type logger
	
	//method for initilizing a browser
		public static WebDriver initilizeBrowser() throws IOException {
			if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				// os
				if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN11);
				} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				} else {
					System.out.println("No matching OS..");
				}
				// browser
				switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				default:
					System.out.println("No matching browser");
				}

				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

			} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
				switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					driver = new ChromeDriver();		; // creating an instance for the chrome driver
					break;
				case "edge":
					driver = new EdgeDriver();		; // creating an instance for the edge driver
					break;
				default:
					System.out.println("No matching browser");		// printing if browser doesnt matches with any of the mentioned browsers in config file
					driver = null;
				}
			}
			driver.manage().deleteAllCookies();		// deleting all the cookies
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;

		}
		
		
		//method for returning the driver
		public static WebDriver getDriver() {
			return driver;
		}
		
		//method for accessing properties
		public static Properties getProperties() throws IOException {
			FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			properties = new Properties();		// creating an object for the properties
			properties.load(file);		// loading properties file
			return properties;		// returning the properties object
		}
		
		//method for loggers
		public static Logger getLogger() {
			logger = LogManager.getLogger();
			return logger;
		}
		
		//Method to generate a random index
		public static int getRandomIndex(int limit) {
			Random r = new Random();
			int randomIndex = r.nextInt(limit);
			return randomIndex;
		}

}
