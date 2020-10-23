package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class LognPage extends BasePage {

	WebDriver driver; // as this is already declared in BasePage class parent class so no need to specify here
    ElementUtil elementUtil;
	//create Locators: By Locators

	By emailId = By.id("username");
	By password = By.id("password");
	By signUp = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");


	//create constructor

	public LognPage(WebDriver driver) {
		this.driver = driver;
		 elementUtil = new ElementUtil(driver);

	}

	//page actions/ page methods
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitlePresent(Constants.Login_Page_Title, 10);
	}

	public boolean signUpLinkPresent() {
		return elementUtil.doIsDisplayed(signupLink);
	}


	public HomePage loginAccount(String username, String pwd) {

		elementUtil.doActionsSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil .doClick(signUp);
		return new HomePage(driver);
	}    

}
