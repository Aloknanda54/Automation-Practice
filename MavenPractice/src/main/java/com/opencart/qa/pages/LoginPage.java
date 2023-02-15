package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//PageFactory - OR
	//Defining webelements on the login page
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/a")
	WebElement signupBtn;
	
	@FindBy(xpath = "//*[@id=\"logo\"]/a/img")
	WebElement logo;
	
	//constructor of login page --Initializing page objects
	public LoginPage() {
		//initialize page factory method
		PageFactory.initElements(driver, this);  //this pointgs to the current class object (LoginPage)
	}
	
	//defining login page actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateImage() {
		return logo.isDisplayed();
	}
	
	public AccountPage login(String mail, String pwd) {
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new AccountPage();
	}
}
