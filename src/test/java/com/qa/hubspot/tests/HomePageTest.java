package com.qa.hubspot.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;

public class HomePageTest extends BaseTest {


	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.loginAccount(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}

	@Test(priority = 1)
	public void HomePageHeaderTest() {
		String header = homePage.getPageHeaderValue();
		Assert.assertEquals(header, Constants.PAGE_HEADER);
	}

	@Test(priority = 2)
	public void HomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, Constants.PAGE_TITLE);
	}

	@Test (priority = 3)
	public void userAccountNameTest() {
		String accountName = homePage.getHomePageTitle();
		Assert.assertEquals(accountName, prop.getProperty("accountname").trim());
	}

	@Test(priority = 4) 
	public void  settingIconExistsTest() {
		Assert.assertTrue(homePage.isExistSettingIcon());
	}


}
