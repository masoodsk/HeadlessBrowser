package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.testBase;

public class HotelBooking {

	public WebDriver driver;
	String date, month, year;
	String caldt, calmonth, calyear;

	@FindBy(xpath = "//*[@id='Tags']")
	private WebElement whereHotelInput;

	@FindBy(className = "calendar")
	private WebElement cal;
	List<WebElement> rows, cols;

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

	
	public void fn_whereHotelInput(String enterLocation) {
		
		whereHotelInput.sendKeys(enterLocation,Keys.ENTER);
		
	}
	public HotelBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		testBase objBase = new testBase();

	}
}
