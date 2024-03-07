package com.adactinhotel.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotel.qa.base.TestBase;

public class BookingConfirmationPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Order No.')]")
	WebElement orderNo;

	@FindBy(xpath = "//input[@id='my_itinerary']")
	WebElement myItinerary;

	@FindBy(xpath = "//input[@id='search_hotel']")
	WebElement searchHotel;

	@FindBy(xpath = "//input[@id='logout']")
	WebElement logoutBtn;

	// Initializing the Page Objects:
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateBookConfirmationTitle() {
		return driver.getTitle();
	}
	
	public boolean validateOderNo() {
		return orderNo.isDisplayed();
	}
	
	public BookingConfirmationPage myItinerary() {
		myItinerary.click();
		return new BookingConfirmationPage();
	}

}
