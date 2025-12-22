package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link' and @ data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(@class,'small-box-footer')]")
	WebElement moreInfoAdminLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement moreInfomanageNews;

	public HomePage adminButtonClick() {
		PageUtility page = new PageUtility();
		page.clickButton(admin);
		return this;
	}

	public LoginPage logoutButtonClick() {
		PageUtility page = new PageUtility();
		page.clickButton(logout);
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnMoreInfoAdminLink() {
		PageUtility page = new PageUtility();
		page.clickButton(moreInfoAdminLink);
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnMoreInfomanageNews() {
		PageUtility page = new PageUtility();
		page.clickButton(moreInfomanageNews);
		return new ManageNewsPage(driver);
	}

}