package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
		@Test
		public void verifyWhetherUserIsAbleToLoginWithValidCredential() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");//Reading username from excel.Row0,col0in sheet loginpage
			String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");//Reading password from excel
			LoginPage loginPage = new LoginPage(driver);//Creating an object of LoginPage, passing the WebDriver from Base class.
			loginPage.enterUserNameOnUserNamefield(usernamevalue);//Calling the method inside LoginPage to type-username into-usernamefield
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.signinClick();
			boolean dashboardDisplayed=loginPage.isDashboardDisplayed();
			Assert.assertTrue(dashboardDisplayed, "user was unable to login with valid credentials.");
		}

		@Test
		public void verifyWhetherUserIsAbleToLoginWithValidUserNameandInvalidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.signinClick();
			String expected="7rmart supermarke";
			String actual=loginPage.getTheTitle();
			Assert.assertEquals(actual, expected,"user was able to login with invalid password.");
		}

		@Test
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.signinClick();
			boolean adminusersDisplayed=loginPage.isAdminUsersDispalyed();
			Assert.assertTrue(adminusersDisplayed, "user was unable to login with invalid username");
			
		}

		@Test
		public void verifyWhetherUserIsAbleToLoginWithInValidUserNameandInValidPassword() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
			String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUserNameOnUserNamefield(usernamevalue);
			loginPage.enterPasswordOnPasswordField(passwordvalue);
			loginPage.signinClick();
			String expected="Sign in to start your session";
			String actual=loginPage.getTheHeading();
			Assert.assertEquals(actual, expected,"user was unable to login");
		}

	}


