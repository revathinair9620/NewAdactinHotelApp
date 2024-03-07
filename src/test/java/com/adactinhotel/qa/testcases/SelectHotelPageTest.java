package com.adactinhotel.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactinhotel.qa.base.TestBase;
import com.adactinhotel.qa.pages.LoginPage;
import com.adactinhotel.qa.pages.SearchHotelPage;
import com.adactinhotel.qa.pages.SelectHotelPage;

public class SelectHotelPageTest extends TestBase {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;

	public SelectHotelPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(); // to access the login page class methods
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // to access
																										// login method
		searchHotelPage = new SearchHotelPage();
		selectHotelPage = new SelectHotelPage();
		searchHotelPage.select_locationviadropdown();
		searchHotelPage.select_hotelviadropdown();
		searchHotelPage.select_roomtypeviadropdown();
		searchHotelPage.submit();

	}

	@Test(priority = 1)
	public void selectHotelPageTitleTest() {
		String title = selectHotelPage.validateSelectHotelPageTitle();
		Assert.assertEquals(title, "Adactin.com - Select Hotel");
	}

	@Test(priority = 2)
	public void selectHotelBtn() {
		selectHotelPage.selectHotel();
		selectHotelPage.submit();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
