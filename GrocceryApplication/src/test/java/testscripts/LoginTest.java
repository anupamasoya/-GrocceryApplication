package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "Verify User can login with valid credentials", groups = { "smoke" })
	public void verifyWhetherUserIsAbleToLoginWithValidCredential()
			throws IOException {
		 String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");//
		// Reading username from excel.Row0,col0in
		// sheet loginpage
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		// Reading password from excel
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.signinClick();
		boolean dashboardDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constants.VALIDCREDENTIALS);
	}

	@Test(priority = 2, description = "Verify User is able to login with valid username and invalid password")
	public void verifyWhetherUserIsAbleToLoginWithValidUserNameandInvalidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		 String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinClick();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, Constants.VALIDUSERNAMEANDINVALIDPASSWORD);
	}

	@Test(priority = 3, description = "Verify user is able to login with invalid username and valid password")
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandValidPassword() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinClick();
		String expected = "Sign in to start your session";
		String actual = loginPage.getTheHeading();
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEANDVALIDPASSWORD);
		//boolean adminusersDisplayed=loginPage.isAdminUsersDispalyed();
		//Assert.assertTrue(adminusersDisplayed, "user was able to login with invalid username");

	}

	@Test(priority = 4, description = "Verify user is able to login with invalid credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandInValidPassword(String usernamevalue,
			String passwordvalue) throws IOException {
		// String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		// String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue).signinClick();
		String expected = "Sign in to start your session";
		String actual = loginPage.getTheHeading();
		Assert.assertEquals(actual, expected,Constants.VALIDCREDENTIALSERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};

	}
}
