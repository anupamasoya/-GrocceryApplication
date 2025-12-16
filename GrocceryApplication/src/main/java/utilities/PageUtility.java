package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);
	}
	public void selectDropdownByIndex(WebElement element,int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	public void selectDropdownByVisibleText(WebElement element,String text) {
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
	public void clickButton(WebElement element) {
		element.click();
	}
	public void clickCheckbox(WebElement element) {
		element.click();
	}
	
}
