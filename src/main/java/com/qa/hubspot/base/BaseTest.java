package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LognPage;

public class BaseTest {
	
	WebDriver driver;
	protected Properties prop;
	protected BasePage basePage;
	protected LognPage loginPage;
	protected HomePage homePage;
	protected ContactsPage contactsPage;
	
    @Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		basePage = new BasePage();
		prop = basePage.init_property();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LognPage(driver);
		//driver.get("https://app.hubspot.com/login");	

	}
    
    
    
    @AfterTest
	public void tearDown() {
		driver.quit();
	}

}
