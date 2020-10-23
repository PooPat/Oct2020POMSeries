package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementutil;
	
	private By primaryCreateContact = By.id("nav-primary-contacts-branch");
	private By header = By.cssSelector("span[class = 'private-dropdown__item__label']");
	private By emailId = By.xpath("//input[@data-field = 'email']");
	private By firstName = By.xpath("//input[@data-field = 'firstname']");
	private By lastName = By.xpath("//input[@data-field = 'lastname']");
	private By jobTitle = By.xpath("//textarea[@data-field = 'jobtitle']");
	private By secondaryCreateContact = By.xpath("span[text()='Create contact']");
	private By contactBackLink = By.linkText("Contacts");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		
	}
	
	public String getContactPageHeaderValue() {
		return elementutil.doGetText(header);
	}
	
	public String getContactsPageTitle() {
		return elementutil.waitForPageTitlePresent(Constants.CONTACT_PAGE_TITLE, 20);
	}
	
	public void createContacts(String emailId, String firstName, String lastName, String jobTitle) {
		elementutil.waitForElementToBeLocated(primaryCreateContact, 20);
		elementutil.doClick(primaryCreateContact);
		
		elementutil.waitForElementToBeLocated(this.emailId, 10);
		elementutil.doSendKeys(this.emailId, emailId);
		elementutil.doSendKeys(this.firstName, firstName);
		elementutil.doSendKeys(this.lastName, lastName);
		
		elementutil.waitForElementToBeVisible(this.jobTitle, 5);
		elementutil.doSendKeys(this.jobTitle, jobTitle);
		
		elementutil.clickWhenReady(secondaryCreateContact, 5);
		elementutil.clickWhenReady(contactBackLink, 5);
	}
	
	
}
