package com.adactinhotel.qa.testcases;

import com.adactinhotel.qa.base.TestBase;
import com.adactinhotel.qa.pages.LoginPage;
import com.adactinhotel.qa.pages.SearchHotelPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;

	public LoginPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Adactin.com - Hotel Reservation System");
	}

	@Test(priority = 2)
	public void ImageTest(){
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
