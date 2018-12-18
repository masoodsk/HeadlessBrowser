package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testBase {

	public static final Logger logger = Logger.getLogger(testBase.class.getName());
	public WebDriver driver;
	public static Properties OR;
	public File f1;
	public FileInputStream file;

	@BeforeTest
	public void launchBrowser() throws IOException {
		loadPropertiesFile();
		String getBr = OR.getProperty("Browser");
		String getUrls = OR.getProperty("urls");
		getBrowser(getBr);
		driver.get(getUrls);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void loadPropertiesFile() throws IOException {
		OR = new Properties();
		try {

			f1 = new File(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			file = new FileInputStream(f1);
			OR.load(file);
			logger.info("loading config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void getBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	
}