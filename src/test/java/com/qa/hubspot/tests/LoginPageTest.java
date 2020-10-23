package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;


public class LoginPageTest extends BaseTest{
	


	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("Title of Page is :" + titleLoginPage );
		Assert.assertEquals(titleLoginPage, Constants.Login_Page_Title, Constants.TITLE_ERR_MSG);
	}

	@Test(priority = 1)
	public void verifySignupLinkVsibleTest() {
		Assert.assertTrue(loginPage.signUpLinkPresent(), Constants.SIGNUP_LINK_ERR_MSG);
	}

	@Test(priority = 3)
	public void loginTest() {
		HomePage homePage =loginPage.loginAccount(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String homePgTitle = homePage.getHomePageTitle();
		System.out.println("Home Page title is: "+ homePgTitle);
		Assert.assertEquals(homePgTitle, prop.getProperty("accountname"));
	}



	
}
