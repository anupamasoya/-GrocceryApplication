package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	@Test(priority = 1, description = "Verify whether admin is able to add new user")
	public void verifyWhetherAdminIsAbleToAddNewUser() throws IOException {// clickOnMoreInfoLink()
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signinClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton();
		FakerUtility fakerUtility = new FakerUtility();
		String newUsername = fakerUtility.createRandomUsername();
		String newPassword = fakerUtility.createFakePassword();
		// String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		// String newPassword = ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		String userType = ExcelUtility.getStringData(0, 2, "AdminUsersPage");
		adminUsersPage.enterUserNameOnUserNameField(newUsername);
		adminUsersPage.enterPasswordOnPasswordField(newPassword);
		adminUsersPage.selectTheUserType(userType);
		adminUsersPage.saveButtonClick();
		boolean userAddedAlertDisplayed = adminUsersPage.userAddedSuccessMessage();
		Assert.assertTrue(userAddedAlertDisplayed, "User is not able to add new user.");

	}

	@Test(priority = 2, description = "Verify Whether Admin Is Able To Search The Newly AddedUser")
	public void verifyWhetherAdminIsAbleToSearchTheNewlyAddedUser() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signinClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.searchButtonClick();
		String newUsername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsersPage.enterTheUserNameToSearch(newUsername);
		adminUsersPage.searchButtonClickToCheckUserName();
		boolean adminUsersResultTabDisplayed = adminUsersPage.isSearchAdminUsersResultTabDisplayed();
		Assert.assertTrue(adminUsersResultTabDisplayed, "User is not able to search for the user.");
	}

	@Test(priority = 3, description = "Verify Whether Admin Is Able To Reset The UsersList")
	public void verifyWhetherAdminIsAbleToResetTheUsersList() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "loginPage");
		String password = ExcelUtility.getStringData(0, 1, "loginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.signinClick();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreInfoLink();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.resetButtonClick();
		boolean adminUsersListDisplayed = adminUsersPage.isAdminUsersListDisplayed();
		Assert.assertTrue(adminUsersListDisplayed, "User list is not reset.");
	}
}