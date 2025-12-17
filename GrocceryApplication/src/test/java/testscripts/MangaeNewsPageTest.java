package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import pages.ManageNewsPage;

public class MangaeNewsPageTest extends Base {
	HomePage home;
	ManageNewsPage managenews;
	@Test
	public void verifyWhetherAdminIsAbleToAddNews() throws IOException {// clickOnMoreInfoLink()
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username).enterPasswordOnPasswordField(password);
		home=loginPage.signinClick();
		
		managenews=home.clickOnMoreInfomanageNews();
	
		managenews.clickNewButton();
		String newsvalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTheNews(newsvalue).clickSaveButton();
		boolean newsCreatedAlert = managenews.newsCreatedAlert();
		Assert.assertTrue(newsCreatedAlert, "not possible to create news");
	}

	@Test
	public void verifyWhetherAdminIsAbleToSearchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username).enterPasswordOnPasswordField(password);
		home=loginPage.signinClick();
		managenews=home.clickOnMoreInfomanageNews();
		managenews.clickSearchButton();
		String titlevalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleToSearch(titlevalue).clickSearchResultButton();

	}

	@Test
	public void verifyAdminIsAbleToResetTheNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNamefield(username).enterPasswordOnPasswordField(password);
		home=loginPage.signinClick();
		managenews=home.clickOnMoreInfomanageNews();
		managenews.clickSearchButton();
		String titlevalue = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		managenews.enterTitleToSearch(titlevalue).clickResetButton();

	}
}
