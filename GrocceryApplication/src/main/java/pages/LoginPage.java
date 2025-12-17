package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// It tells Selenium to find all the elements you defined using @FindBy.
	}

	@FindBy(name = "username")
	WebElement userName;// Finds the username input box using its name attribute.
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;// xpath
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement title;
	@FindBy(xpath = " //p[text()='Admin Users']")
	WebElement adminUsers;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement heading;

	public LoginPage enterUserNameOnUserNamefield(String usernamevalue) { // Takes a String usernamevalue
		userName.sendKeys(usernamevalue);
		return this;  // Types that value inside the username field.
	}

	public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}

	public HomePage signinClick() {
		signInBtn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public String getTheTitle() {
		return title.getText();
	}

	public boolean isAdminUsersDispalyed() {
		return adminUsers.isDisplayed();
	}

	public String getTheHeading() {
		return heading.getText();
	}

}
