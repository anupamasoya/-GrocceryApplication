package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),' New')]")
	WebElement newLink;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userTypeDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//a[contains(text(),' Search')]")
	WebElement searchLink;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUserName;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//a[contains(text(),' Reset')]")
	WebElement resetLink;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible' or @class='alert alert-danger alert-dismissible']")
	WebElement userAddedSuccessMessage;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	WebElement searchAdminUsersResultTab;
	@FindBy(xpath = "//h4[text()='Admin Users']//ancestor::div[@class='card']")
	WebElement adminUsersList;

	public AdminUsersPage clickOnNewButton() {
		PageUtility page = new PageUtility();
		page.clickButton(newLink);
		return this;
	}

	public AdminUsersPage enterNewUserNameOnUserNameField(String newUserNameValue) {
		userName.sendKeys(newUserNameValue);
		return this;
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPasswordValue) {
		password.sendKeys(newPasswordValue);
		return this;
	}

	public AdminUsersPage selectTheUserType(String userTypeValue) {
		PageUtility page = new PageUtility();
		page.selectDropdownByVisibleText(userTypeDropdown, userTypeValue);
		return this;
	}

	public AdminUsersPage saveButtonClick() {
		WaitUtility wait = new WaitUtility();
		wait.waitUntilElementToBeClickable(driver, saveButton);
		PageUtility page = new PageUtility();
		page.clickButton(saveButton);
		return this;
	}

	public AdminUsersPage searchButtonClick() {
		PageUtility page = new PageUtility();
		page.clickButton(searchLink);
		return this;
	}

	public AdminUsersPage enterTheUserNameToSearch(String userNameValue) {
		searchUserName.sendKeys(userNameValue);
		return this;
	}

	public AdminUsersPage searchButtonClickToCheckUserName() {
		PageUtility page = new PageUtility();
		page.clickButton(searchButton);
		return this;
	}

	public AdminUsersPage resetButtonClick() {
		PageUtility page = new PageUtility();
		page.clickButton(resetLink);
		// resetLink.click();
		return this;
	}

	public boolean userAddedSuccessMessage() {
		return userAddedSuccessMessage.isDisplayed();
	}

	public boolean isSearchAdminUsersResultTabDisplayed() {
		return searchAdminUsersResultTab.isDisplayed();
	}

	public boolean isAdminUsersListDisplayed() {
		return adminUsersList.isDisplayed();
	}

}