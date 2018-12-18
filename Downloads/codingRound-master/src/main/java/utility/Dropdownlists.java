package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdownlists {

	
	public static void selectElementByNameMethod(WebElement element, String Name) {
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
		}

		public static void selectElementByValueMethod(WebElement element,
		String value) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
		}

		public static void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
		}
}
