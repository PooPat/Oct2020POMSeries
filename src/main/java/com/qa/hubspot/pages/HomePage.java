package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	//create By locators

	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By accountName = By.className("account-name ");
	By settingLink = By.id("navSetting");
	By parentContactsMenu = By.id("nav-primary-contacts-branch");
	By subContactMenu = By.id("nav-secondary-contacts");


	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}


	public String getHomePageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.PAGE_TITLE, 10);
	}

	public String getPageHeaderValue() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	public String getaccountNameValue() {
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}

	public boolean isExistSettingIcon() {
		return elementUtil.doIsDisplayed(settingLink);
	}

    public ContactsPage gotoContactsPage() {
    	clickOnContacts();
    	return new ContactsPage(driver);
    }
    
    private void clickOnContacts() {
    	elementUtil.waitForElementToBeLocated(parentContactsMenu, 10);
    	elementUtil.doClick(parentContactsMenu);
    	elementUtil.clickWhenReady(subContactMenu, 5);
    	
    }


}
