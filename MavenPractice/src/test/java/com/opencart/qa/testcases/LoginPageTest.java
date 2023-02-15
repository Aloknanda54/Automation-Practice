package com.opencart.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.TestBase;
import com.opencart.qa.pages.AccountPage;
import com.opencart.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	
	//constructor of login page
	public LoginPageTest() throws IOException {
		super(); //call base class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage  = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Account Login");	
		}
	@Test(priority=2)
	public void LogoImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		accountPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();	
	}

}
