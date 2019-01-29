package BrowserUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class BrowserApp {
	WebDriver driver;

	@Test
	public void LaunchBr() {

		String driverpath = "./src/main/resources/Driver/chromedriver.exe";
		String dripath = "./src/main/resources/Driver/geckodriver.exe";
		String getdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", getdir + driverpath);
		System.setProperty("webdriver.gecko.driver", getdir + dripath);
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		driver.get("http://apps.gamonoid.com/icehrm-open/");
		System.out.println(driver.getTitle());
		driver.quit();
		/*
		 * FirefoxBinary obj = new FirefoxBinary();
		 * obj.addCommandLineOptions("--headless"); FirefoxOptions firefoxOptions = new
		 * FirefoxOptions(); firefoxOptions.setBinary(obj); driver = new
		 * FirefoxDriver(firefoxOptions);
		 * driver.get("http://apps.gamonoid.com/icehrm-open/");
		 * System.out.println(driver.getTitle()); driver.quit();
		 */
	}

}
