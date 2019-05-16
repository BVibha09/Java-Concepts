package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.commons.Constants;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class HomePageTest {

	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		CommonUtil.mediumwait();
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		
		String title = homePage.getHomePageTitle();
		System.out.println("Title of the home page is: " +title);
		Assert.assertEquals(title, Constants.HOMEPAGE_TITLE, "Home page title is not correct");	
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		
		String header = homePage.getHomePageHeader();
		System.out.println("Header of the home page is: " +header);
		Assert.assertEquals(header, Constants.HOMEPAGE_HEADER, "Home page header is not correct");
	}
	
	@Test(priority=3)
	public void verifyLoggedInAccountNameTest(){
		String accountName = homePage.getLoggedInAccountName();
		System.out.println("LoggedIn account name is: " +accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
