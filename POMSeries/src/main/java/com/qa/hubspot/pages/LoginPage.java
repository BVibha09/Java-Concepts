	package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	
	/*In every page class, according to POM, 2 things are mandatory
	 * 1. Define page objects with the help of page factory or By locator
	 * 2. Page actions/methods of the feature
	 */
	
	WebDriver driver;
	
	//1.a -> Define page objects
	@FindBy(id="username")
	WebElement emailId;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign Up")
	WebElement signUpLink;
	
	//1.b -> Create a constructor of page class and initialize all the page objects with driver
	
	public LoginPage(WebDriver driver){
		
		this.driver = driver;
		//PageFactory.initElements(driver, LoginPage.class);
					//OR
		PageFactory.initElements(driver, this);
	}
	
	//2 -> Define actions/methods
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifySignUpLink(){
		return signUpLink.isDisplayed();
	}
	
	public HomePage doLogin(String un, String pwd){
		emailId.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	

}
