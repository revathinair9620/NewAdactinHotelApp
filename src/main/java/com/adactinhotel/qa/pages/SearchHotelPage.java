package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactinhotel.qa.base.TestBase;

public class SearchHotelPage extends TestBase {

	@FindBy(xpath = "//input[@value='Hello Revathinair!']")
	WebElement userNameLabel;

	@FindBy(xpath = "//*[@id=\"location\"]")
	WebElement location;

	@FindBy(xpath = "//*[@id=\"hotels\"]")
	WebElement hotels;

	@FindBy(xpath = "//*[@id=\"room_type\"]")
	WebElement roomtype;

	@FindBy(xpath = "//input[@id='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//*[@id=\"datepick_in\"]")
	WebElement checkInDate;
	
	@FindBy(xpath = "//*[@id=\"datepick_out\"]")
	WebElement checkOutDate;
	
	

	// Initializing the Page Objects:
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
    //Actions
	public String validateSearchHotelPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public void select_locationviadropdown() {
		Select loc = new Select(location);
		loc.selectByIndex(1);
	}

	public void select_hotelviadropdown() {
		Select hotel = new Select(hotels);
		hotel.selectByIndex(1);
	}

	public void select_roomtypeviadropdown() {
		Select roomtypes = new Select(roomtype);
		roomtypes.selectByIndex(1);
	}
	
	public void enterdate(String checkindate, String checkoutdate) {
		checkInDate.clear();
		checkInDate.sendKeys(checkindate);
		checkOutDate.clear();
		checkOutDate.sendKeys(checkoutdate);
		
	}

	public SelectHotelPage submit() {
		submitBtn.click();
		return new SelectHotelPage();
	}

}
