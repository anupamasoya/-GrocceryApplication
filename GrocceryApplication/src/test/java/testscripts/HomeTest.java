package testscripts;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.apache.commons.math3.analysis.function.Constant;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "Verify whether User is able to successfully logout", retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToSuccessfullyLogout() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "Loginpage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "Loginpage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = loginPage.signinClick();

		home.adminButtonClick();
		loginPage = home.logoutButtonClick();
		String expected = "7rmart supermarket";
		String actual = loginPage.getTheTitle();
		Assert.assertEquals(actual, expected, Constants.LOGOUT);

	}

}
