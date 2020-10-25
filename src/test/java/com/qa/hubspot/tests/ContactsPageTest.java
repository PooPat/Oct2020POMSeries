package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcellUtil;

public class ContactsPageTest extends BaseTest {
	
	

	@BeforeClass
	public void openApplicatio() {
		
		homePage = loginPage.loginAccount(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		contactsPage =  homePage.gotoContactsPage();
	
	}
	
	@Test
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contact page title is :"+ title);
		Assert.assertEquals(title, Constants.CONTACT_PAGE_TITLE);
	}
	
@Test(priority = 1)
public void verifyContactsPageHeaderTest() {
	String header = contactsPage.getContactPageHeaderValue();
	System.out.println("Contacts page header is :"+ header);
	Assert.assertEquals(header, Constants.CONTACT_PAGE_HEADER);
		
	}
@DataProvider
public Object[][] getContactsData() {
	Object data[][] = ExcellUtil.getTestData(Constants.Contacts_Sheet_Name);
	return data;
}
	
@Test(priority=2, dataProvider= "getContactsData")
public void verifyCreateContactTest(String emailId, String firstName, String lastName, String jobTitle) {
	contactsPage.createContacts("emailId", "firstName", "lastName", "jobTitle");
	
	
}

	
}
