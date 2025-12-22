package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement searchNewsField;
	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchButton;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchResultButton;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchTile;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//table[contains(@class,'table')]")
	WebElement newsTable;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertNewsCreatedSuccecssfully;

	public ManageNewsPage clickNewButton() {
		PageUtility page = new PageUtility();
		page.clickButton(newButton);
		return this;
	}

	public ManageNewsPage enterTheNews(String newsvalue) {
		searchNewsField.sendKeys(newsvalue);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		PageUtility page = new PageUtility();
		page.clickButton(saveButton);
		return this;
	}

	public ManageNewsPage clickSearchButton() {
		PageUtility page = new PageUtility();
		page.clickButton(searchButton);
		return this;
	}

	public ManageNewsPage enterTitleToSearch(String titlevalue) {
		searchTile.sendKeys(titlevalue);
		return this;
	}

	public ManageNewsPage clickResetButton() {
		PageUtility page = new PageUtility();
		page.clickButton(resetButton);
		return this;
	}

	public boolean isNewsListDisplayed() {
		return newsTable.isDisplayed();
	}

	public ManageNewsPage clickSearchResultButton() {
		PageUtility page = new PageUtility();
		page.clickButton(searchResultButton);
		return this;
	}

	public boolean newsCreatedAlert() {
		return alertNewsCreatedSuccecssfully.isDisplayed();
	}

}
