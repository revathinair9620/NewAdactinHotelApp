package com.adactinhotel.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinhotel.qa.base.TestBase;
import com.adactinhotel.qa.pages.LoginPage;
import com.adactinhotel.qa.pages.SearchHotelPage;

public class SearchHotelTest extends TestBase {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;

	public SearchHotelTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); // to access the login page class methods
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // to access
																										// login method
	}

	@Test(priority = 1)
	public void searchHotelPageTitleTest() {
		String title = searchHotelPage.validateSearchHotelPageTitle();
		Assert.assertEquals(title, "Adactin.com - Search Hotel");
	}
	
	@Test(priority = 1)
	public void userName() {
		boolean flag = searchHotelPage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void selectvalues() {
		searchHotelPage.select_locationviadropdown();
		searchHotelPage.select_hotelviadropdown();
		searchHotelPage.select_roomtypeviadropdown();
		searchHotelPage.submit();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
