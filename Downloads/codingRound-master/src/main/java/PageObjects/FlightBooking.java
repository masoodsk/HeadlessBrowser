package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.testBase;
import utility.Dropdownlists;
import utility.WaitForduration;

public class FlightBooking extends testBase {

	public WebDriver driver;

	String date, month, year;
	String caldt, calmonth, calyear;
	@FindBy(xpath = "//*[@id='OneWay']")
	private WebElement onewayTrip;

	@FindBy(xpath = "//*[@id='RoundTrip']")
	private WebElement RoundTripselection;

	@FindBy(xpath = "//*[@id='MultiCity']")
	private WebElement multiCitySelection;

	@FindBy(xpath = "//*[@id='FromTag']")
	private WebElement fromway;

	@FindBy(xpath = "//*[@id='ToTag']")
	private WebElement Toway;

	@FindBy(xpath = "//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i")
	private WebElement clickoncalendar;

	@FindBy(className = "calendar")
	private WebElement cal;
	List<WebElement> rows, cols;

	@FindBy(xpath = "//*[@id='Adults']")
	private WebElement selAdults;
	@FindBy(xpath = "//*[@id='Childrens']")
	private WebElement selChildrens;
	@FindBy(xpath = "//*[@id='Infants']")
	private WebElement selInfants;
	@FindBy(xpath = "//*[@id='SearchBtn']")
	private WebElement searchFlight;

	@FindBy(xpath = "//*[@id='GlobalNav']/div/div[1]/ul/li[2]/a/span")
	private WebElement clickonHotelBooking;

	public FlightBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testBase objBase = new testBase();

	}

	public void oneWaySelection() {
		onewayTrip.click();

	}

	public void RoundWaySelection() {
		if (RoundTripselection.isDisplayed()) {
			System.out.println("RoundTrip is Display");
			RoundTripselection.click();
		}
	}

	public void MultiSelection() {
		multiCitySelection.click();

	}

	public void Journey(String fromwayinput, String towayinput) {

		fromway.sendKeys(fromwayinput, Keys.DOWN);

		Toway.sendKeys(towayinput);
		Toway.sendKeys(Keys.TAB);
	}

	public void fn_clickoncalendar() {
		clickoncalendar.click();

	}

	public void fn_Selectdates(String inputdate) {

		String dateArray[] = inputdate.split("/");
		date = dateArray[0];
		month = dateArray[1];
		year = dateArray[2];
		rows = cal.findElements(By.tagName("tr"));
		for (int i = 1; i < rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				caldt = cols.get(j).getText();
				if (caldt.equals(date)) {
					cols.get(j).click();
					break;
				}
			}
		}

	}

	public void fn_selAdults(int index) {
		Dropdownlists.selectElementByIndexMethod(selAdults, index);
	}

	public void fn_selChildrens(int index) {
		Dropdownlists.selectElementByIndexMethod(selChildrens, index);
	}

	public void fn_selInfants(int index) {
		Dropdownlists.selectElementByIndexMethod(selInfants, index);
	}

	public void fn_searchFlight() {

		try {
			searchFlight.click();	
		}catch(Exception e) {
			System.out.println("Search the Flight details"+e.getMessage());
		}
		

	}

	public void fn_clickonHotelBooking() {
		try {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WaitForduration.waitTillElementFound(driver, clickonHotelBooking, 50);
		clickonHotelBooking.click();
		}catch(Exception e) {
		System.out.println("Element is not present");
		}

	}
}
